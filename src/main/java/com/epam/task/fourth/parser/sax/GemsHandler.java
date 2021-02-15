package com.epam.task.fourth.parser.sax;

import com.epam.task.fourth.entity.Gems;
import com.epam.task.fourth.entity.Precious;
import com.epam.task.fourth.entity.Semiprecious;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GemsHandler extends DefaultHandler {
    private final Logger LOGGER = Logger.getLogger(GemsHandler.class);

    private List<Gems> gems = new ArrayList<>();
    private Gems currentGem = null;
    private String tag = null;

    public List<Gems> getGems() {
        return gems;
    }

    private final String PRECIOUS = "precious";
    private final String SEMIPRECIOUS = "semiprecious";
    private final String NAME = "name";
    private final String COLOR = "color";
    private final String VALUE = "value";
    private final String TRANSPARENCY = "transparency";
    private final String EDGES = "edges";
    private final List<String> INFO_TAGS = Arrays.asList(NAME, COLOR, VALUE, TRANSPARENCY, EDGES);

    @Override
    public void startDocument() throws SAXException {
        LOGGER.info("Start SAX parsing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (localName) {
            case PRECIOUS:
                currentGem = new Precious();
                currentGem.setId(attributes.getValue("id"));
                if (attributes.getLength() == 2) {
                    String value = attributes.getValue("amount");
                    currentGem.setAmount(Integer.parseInt(value));
                }
                break;
            case SEMIPRECIOUS:
                currentGem = new Semiprecious();
                currentGem.setId(attributes.getValue("id"));
                if (attributes.getLength() == 2) {
                    String value = attributes.getValue("amount");
                    currentGem.setAmount(Integer.parseInt(value));
                }
                break;
        }
        if (INFO_TAGS.contains(localName)){
            tag = localName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (PRECIOUS.equals(localName) || SEMIPRECIOUS.equals(localName)) {
            gems.add(currentGem);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);
        if (tag != null) {
            switch (tag){
                case NAME:
                    currentGem.setName(text);
                    break;
                case COLOR:
                    currentGem.setColor(text);
                    break;
                case VALUE:
                    currentGem.setValue(Integer.parseInt(text));
                    break;
                case TRANSPARENCY:
                    Semiprecious semi = new Semiprecious(currentGem);
                    semi.setTransparency(Integer.parseInt(text));
                    currentGem = semi;
                    break;
                case EDGES:
                    Precious pres = new Precious((Semiprecious) currentGem);
                    pres.setEdges(Integer.parseInt(text));
                    currentGem = pres;
                    break;
                default:
                    LOGGER.error("<" + text + "> no such tag");
            }
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.info("SAX parsing is complete");
    }
}
