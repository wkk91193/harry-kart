package se.atg.service.harrykart.java.response;

import com.fasterxml.jackson.core.JsonProcessingException;


public interface ResponseGenerator {
    public String generateResponse(int statusCode, Object message) throws JsonProcessingException;
}
