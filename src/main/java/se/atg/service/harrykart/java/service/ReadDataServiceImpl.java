package se.atg.service.harrykart.java.service;

import org.springframework.stereotype.Service;
import se.atg.service.harrykart.java.constants.ExceptionMessageConstants;
import se.atg.service.harrykart.java.exceptions.UserInputException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
public class ReadDataServiceImpl implements ReadDataService {


    @Override
    public <T,G> T readXmlData(String xmlData,  G objectfactory) throws UserInputException {
        try {
            JAXBContext jc = JAXBContext.newInstance(objectfactory.getClass());
            Unmarshaller um = jc.createUnmarshaller();

            //GameType: Generated pojo, root element
            JAXBElement<T> raceInfo = (JAXBElement<T>) um.unmarshal(new StringReader(xmlData));
            return (T) raceInfo;

        }catch (JAXBException ex){
            throw new UserInputException(ExceptionMessageConstants.INVALID_XML+" "+ex.getLinkedException().getMessage());
        }

    }


}
