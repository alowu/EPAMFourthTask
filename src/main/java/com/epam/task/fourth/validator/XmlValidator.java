package com.epam.task.fourth.validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
    private final Logger LOGGER = Logger.getLogger(XmlValidator.class);

    public boolean isValid(String fileName, String schemaName){
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaLocation = new File(schemaName);
        Schema schema = null;

        boolean valid = false;

        try {
            schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);

            LOGGER.info(fileName + " is valid");
            valid = true;
        } catch (SAXException | IOException e) {
            LOGGER.error("Validation " + fileName + " isn't valid cause " +
                    e.getMessage(), e);
        }
        return valid;
    }
}
