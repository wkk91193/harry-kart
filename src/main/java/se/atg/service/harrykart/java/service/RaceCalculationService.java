package se.atg.service.harrykart.java.service;

import se.atg.service.harrykart.java.exceptions.UserInputException;
import se.atg.service.harrykart.java.models.HarryKartType;
import se.atg.service.harrykart.java.models.RaceResult;

import java.util.List;

public interface RaceCalculationService {

    public List<RaceResult> calculateWinners(HarryKartType Race) throws UserInputException;
}
