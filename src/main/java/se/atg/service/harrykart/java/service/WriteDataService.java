package se.atg.service.harrykart.java.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Collection;
import java.util.List;

public interface WriteDataService {

    public <T>String writeDataObjectAsJson(T objectToBeSerialised) throws JsonProcessingException;
}

