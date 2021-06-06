package se.atg.service.harrykart.java.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.atg.service.harrykart.java.models.ResponseModel;
import se.atg.service.harrykart.java.service.WriteDataService;

@Component
public class ResponseGeneratorImpl implements ResponseGenerator {

    private final WriteDataService writeDataService;

    @Autowired
    public ResponseGeneratorImpl(WriteDataService writeDataService) {
        this.writeDataService = writeDataService;
    }

    @Override
    public String generateResponse(int statusCode, Object message) throws JsonProcessingException {
        ResponseModel responseModel = new ResponseModel(statusCode,message);
        return this.writeDataService.writeDataObjectAsJson(responseModel);

    }
}
