package com.epam.task.fourth.parser.jaxb;

import com.epam.task.fourth.entity.Gem;
import com.epam.task.fourth.entity.Gems;
import com.epam.task.fourth.parser.ParsingException;
import com.epam.task.fourth.parser.XmlParser;
import com.epam.task.fourth.validator.XmlException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import java.io.File;
import java.util.List;

public class JaxbParser implements XmlParser {
    private static final Logger LOGGER = Logger.getLogger(JaxbParser.class);
    private final String schemaName = "inputData/gems.xsd";

    @Override
    public List<Gem> parse(String xmlFile) throws ParsingException {
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Gems.class);
            Unmarshaller um = jc.createUnmarshaller();
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File xsd = new File(schemaName);
            Schema schema = factory.newSchema(xsd);
            um.setSchema(schema);
            Gems gems = (Gems) um.unmarshal(new File(xmlFile));

            return gems.getGems();
        } catch (JAXBException | SAXException e) {
            LOGGER.error("error while JAXB parsing " + e.getMessage(), e);
            throw new ParsingException(e);
        }
    }
}
