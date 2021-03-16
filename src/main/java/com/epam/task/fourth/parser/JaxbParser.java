package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Gem;
import com.epam.task.fourth.entity.Gems;

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
        File file = new File(xmlFile);
        if (!file.exists()) {
            throw new ParsingException("File " + xmlFile + " not exists");
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Gems.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Gems gems = (Gems) unmarshaller.unmarshal(file);

            return gems.getGems();
        } catch (JAXBException e) {
            throw new ParsingException(e);
        }
    }
}
