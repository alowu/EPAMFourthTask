package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Gem;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements XmlParser {
    private static final Logger LOGGER = Logger.getLogger(SaxParser.class);

    @Override
    public List<Gem> parse(String xmlFile) throws ParsingException {
        List<Gem> gems;
        final GemsHandler gemsHandler = new GemsHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(gemsHandler);
            reader.parse(xmlFile);
            gems = gemsHandler.getGems();

            LOGGER.info(xmlFile + " parsed");
            return gems;
        } catch (SAXException | IOException e) {
            throw new ParsingException(e);
        }
    }
}
