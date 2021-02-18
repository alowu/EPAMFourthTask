package com.epam.task.fourth.parser.sax;

import com.epam.task.fourth.entity.Gem;
import com.epam.task.fourth.parser.ParsingException;
import com.epam.task.fourth.parser.XmlParser;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements XmlParser {
    private static final Logger LOGGER = Logger.getLogger(SaxParser.class);
    private String fileName;
    private List<Gem> gems;
    private final GemsHandler gemsHandler = new GemsHandler();
    private XMLReader reader;

    @Override
    public List<Gem> parse(String xmlFile) throws ParsingException {
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(gemsHandler);
            reader.parse(xmlFile);
            gems = gemsHandler.getGems();

            LOGGER.info(xmlFile + " parsed");
            return gems;
        } catch (SAXException | IOException e) {
            throw new ParsingException(e);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
