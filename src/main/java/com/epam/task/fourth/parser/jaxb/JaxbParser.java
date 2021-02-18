package com.epam.task.fourth.parser.jaxb;

import com.epam.task.fourth.entity.Gem;
import com.epam.task.fourth.entity.Gems;
import com.epam.task.fourth.parser.ParsingException;
import com.epam.task.fourth.parser.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;

public class JaxbParser implements XmlParser {
    private static final Logger LOGGER = Logger.getLogger(JaxbParser.class);

    @Override
    public List<Gem> parse(String xmlFile) throws ParsingException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Gems.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Gems gems = (Gems) unmarshaller.unmarshal(new File(xmlFile));

            return gems.getGems();
        } catch (JAXBException e) {
            LOGGER.error("error while JAXB parsing " + e.getMessage(), e);
            throw new ParsingException(e);
        }
    }
}
