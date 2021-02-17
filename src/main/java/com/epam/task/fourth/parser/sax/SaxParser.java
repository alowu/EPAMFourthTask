package com.epam.task.fourth.parser.sax;

import com.epam.task.fourth.entity.Gem;
import com.epam.task.fourth.parser.AbstractParser;
import com.epam.task.fourth.validator.XmlException;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser extends AbstractParser {
    private final Logger LOGGER = Logger.getLogger(SaxParser.class);
    private String fileName;
    private List<Gem> gems;
    private GemsHandler gemsHandler = new GemsHandler();
    private XMLReader reader;

    @Override
    public List<Gem> parseListGems(String xmlFile) throws XmlException {
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(gemsHandler);
            reader.parse(xmlFile);
            gems = gemsHandler.getGems();

            LOGGER.info(xmlFile + " parsed");
            return gems;
        } catch (SAXException | IOException e) {
            LOGGER.error("error while SAX parsing " + e.getMessage(), e);
            throw new XmlException(e.getMessage(), e);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
