package se.atg.service.harrykart.java.service;

import se.atg.service.harrykart.java.exceptions.UserInputException;

import javax.xml.bind.JAXBException;

public interface ReadDataService {
    public <T,G> T readXmlData(String xmlData,  G objectfactory) throws UserInputException;
}
