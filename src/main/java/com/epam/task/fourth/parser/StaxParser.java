package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Gem;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class StaxParser implements XmlParser {
    private static final Logger LOGGER = Logger.getLogger(StaxParser.class);

    @Override
    public List<Gem> parse(String xmlFile) throws ParsingException {
        final GemsHandler gemsHandler = new GemsHandler();
        List<Gem> gems;

        try{
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(gemsHandler);
            reader.parse(xmlFile);
            gems = gemsHandler.getGems();
        } catch (SAXException | IOException e) {
            throw new ParsingException(e);
        }
        return gems;
    }


}
