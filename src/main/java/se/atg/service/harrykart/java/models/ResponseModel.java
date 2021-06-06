package se.atg.service.harrykart.java.models;

public class ResponseModel {
    private final int statusCode;
    private final Object responseMessage;


    public ResponseModel(int statusCode, Object responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Object getResponseMessage() {
        return responseMessage;
    }
}
