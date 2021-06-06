package se.atg.service.harrykart.java.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class WriteDataServiceImpl implements WriteDataService {


    @Override
    public <T> String writeDataObjectAsJson(T objectToBeSerialised) throws JsonProcessingException{

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(objectToBeSerialised);
    }
}

