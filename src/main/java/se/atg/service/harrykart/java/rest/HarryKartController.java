package se.atg.service.harrykart.java.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import se.atg.service.harrykart.java.constants.ExceptionMessageConstants;
import se.atg.service.harrykart.java.exceptions.UserInputException;
import se.atg.service.harrykart.java.models.HarryKartType;
import se.atg.service.harrykart.java.models.ObjectFactory;
import se.atg.service.harrykart.java.models.RaceResult;
import se.atg.service.harrykart.java.response.ResponseGenerator;
import se.atg.service.harrykart.java.service.RaceCalculationService;
import se.atg.service.harrykart.java.service.ReadDataService;
import se.atg.service.harrykart.java.service.WriteDataService;

import javax.xml.bind.JAXBElement;
import java.util.List;

@RestController
@RequestMapping("/java/api")
public class HarryKartController {

    private final RaceCalculationService raceCalculationService;
    private final ReadDataService readDataService;
    private final ResponseGenerator responseGenerator;

    @Autowired
    public HarryKartController(final RaceCalculationService raceCalculationService,
                               final ReadDataService readDataService,
                               final ResponseGenerator responseGenerator){


        this.raceCalculationService = raceCalculationService;
        this.readDataService = readDataService;
        this.responseGenerator =responseGenerator;
    }


    @PostMapping(path = "/play", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String playHarryKart(@RequestBody String xmlString) throws JsonProcessingException {
        //Read the xml
        //Calculate total time for each horse.
        //Output result in json
        String responseMessage= "";
        try {

            JAXBElement<HarryKartType> readData = this.readDataService.readXmlData(xmlString, new ObjectFactory());
            List<RaceResult> result = raceCalculationService.calculateWinners(readData.getValue());
            responseMessage = responseGenerator.generateResponse(HttpStatus.OK.value(),result);

        }catch (Exception ex){

            if (ex instanceof UserInputException){
                responseMessage = responseGenerator.generateResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
            }else{
                responseMessage =responseGenerator.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ExceptionMessageConstants.SOMETHING_WENT_WRONG);
            }

        }
        return responseMessage;

    }

}
