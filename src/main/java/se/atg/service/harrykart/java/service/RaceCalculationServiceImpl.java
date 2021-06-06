package se.atg.service.harrykart.java.service;

import org.springframework.stereotype.Service;
import se.atg.service.harrykart.java.constants.ExceptionMessageConstants;
import se.atg.service.harrykart.java.constants.RaceInfoConstants;
import se.atg.service.harrykart.java.exceptions.UserInputException;
import se.atg.service.harrykart.java.helper.CalculationUtils;
import se.atg.service.harrykart.java.models.*;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RaceCalculationServiceImpl implements RaceCalculationService {


    @Override
    public List<RaceResult> calculateWinners(HarryKartType race) throws UserInputException {
        //For each horse calculate total time
        Map<ParticipantType,Double> timeForEachHorse = CalculateTotalTimeForEachHorse(race);

        //sorted list of participants from fastest to slowest finishers
        List<ParticipantType> participantTypeList = timeForEachHorse.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        //get top K finishers of the race
        List<RaceResult> resultsList =new ArrayList<>();
        for (int i = 0; i < RaceInfoConstants.NUMBER_OF_REQUIRED_RANKINGS; i++) {
            String participantName = participantTypeList.get(i).getName();

            if(CalculationUtils.isNullOrEmptyString(participantName))
                throw new UserInputException(ExceptionMessageConstants.NULL_OR_EMPTY_ARGUEMENTS_FOUND +" for "+RaceInfoConstants.PARTICIPANT_NAME_FIELD);

            RaceResult result = new RaceResult(i+1,participantName);
            resultsList.add(result);
        }

        return resultsList;
    }

    private final Map<ParticipantType,Double> CalculateTotalTimeForEachHorse(HarryKartType race) throws UserInputException {
        //final output
        Map<ParticipantType,Double> totalTimeForEachHorseMap = new HashMap<>();

        //extract the list of participants
        List<ParticipantType> participantTypeList = race.getStartList().getParticipant();

        //build a map of power ups for each loop
        Collection <LoopType> loopTypeList = getMapOfPowerUpsForEachLoop(race).values();

        //denote each lane of participant
        int laneIndex = 0;

        //for each participant
            //1. Get power up value for loop for each horse
            //2. Calculate time for each loop by each horse
            //3. Calculate total time for each horse for completing the race
        for (ParticipantType participant: participantTypeList) {
                double totalTimeForEachHorse =0;
                int powerUp=0;

                for (LoopType loopType :loopTypeList){
                    powerUp = getPowerUpForEachLoopForEachHorse(loopType,laneIndex,powerUp);
                    double timeForSingleLoop = calculateTimeForEachParticipantForEachLoop(participant,powerUp);
                    totalTimeForEachHorse+= timeForSingleLoop;
                }
                totalTimeForEachHorseMap.put(participant,totalTimeForEachHorse);
                laneIndex++;
        }
        return totalTimeForEachHorseMap;

    }

    private  final int getPowerUpForEachLoopForEachHorse(LoopType loopType,int laneIndex,int powerUp) throws UserInputException {
        // return 0 if loop if null
        if(loopType == null)
            return 0;

        //increment power up value based on the value found for the current loop
        BigInteger powerUpBigInt = loopType.getLane().get(laneIndex).getValue();

        if(CalculationUtils.isNullValue(powerUpBigInt) || !CalculationUtils.isNumeric(powerUpBigInt.toString()))
            throw new UserInputException(ExceptionMessageConstants.INVALID_NUMBER+" for "+RaceInfoConstants.POWERUPS_PROPERTY);

         return powerUpBigInt.intValue() + powerUp;

    }

    private final double calculateTimeForEachParticipantForEachLoop(ParticipantType participantType, int powerUp) throws UserInputException {

        BigInteger baseSpeed=participantType.getBaseSpeed();

        if (CalculationUtils.isNullValue(baseSpeed) || !CalculationUtils.isNumeric(baseSpeed.toString()))
            throw new UserInputException(ExceptionMessageConstants.INVALID_NUMBER+ " for "+RaceInfoConstants.BASE_SPEED_FIELD);

        //time taken to complete a loop by a horse
        return CalculationUtils.CalculateTimeBasedonSpeedAndDistance
                (Double.valueOf(baseSpeed.intValue()+powerUp),
                        RaceInfoConstants.DISTANCE_OF_LOOP_IN_METERS);

    }


    private final Map<Integer,LoopType> getMapOfPowerUpsForEachLoop(HarryKartType harryKartType) throws UserInputException {
        //map of powerups for each loop
        Map<Integer, LoopType> mapWithPowerUps = new HashMap<>();

        BigInteger numberOfLoops = harryKartType.getNumberOfLoops();

        if(CalculationUtils.isNullValue(numberOfLoops) || !CalculationUtils.isNumeric(numberOfLoops.toString()))
                throw new UserInputException(ExceptionMessageConstants.INVALID_NUMBER+ " for "+RaceInfoConstants.NUMBER_OF_LOOPS_FIELD);

        //based on the loop index populate the map
        for (int loopIndex = 0; loopIndex < harryKartType.getNumberOfLoops().intValue(); loopIndex++) {
            if(loopIndex==0)
                mapWithPowerUps.put(0,null);
            else {
                mapWithPowerUps.put(loopIndex,harryKartType.getPowerUps().getLoop().get(loopIndex-1));
            }
        }
        return  mapWithPowerUps;

    }


}
