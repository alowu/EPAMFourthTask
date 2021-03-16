package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Gem;
import com.epam.task.fourth.entity.Precious;
import com.epam.task.fourth.entity.Semiprecious;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GemsHandler extends DefaultHandler {
    private static final Logger LOGGER = Logger.getLogger(GemsHandler.class);

    private final List<Gem> gems = new ArrayList<>();
    private Gem currentGem = null;
    private String tag = null;

    private final String PRECIOUS = "precious";
    private final String SEMIPRECIOUS = "semiprecious";
    private final String NAME = "name";
    private final String COLOR = "color";
    private final String VALUE = "value";
    private final String TRANSPARENCY = "transparency";
    private final String EDGES = "edges";
    private final List<String> INFO_TAGS = Arrays.asList(NAME, COLOR, VALUE, TRANSPARENCY, EDGES);

    public List<Gem> getGems() {
        return gems;
    }

    @Override
    public void startDocument(){
        LOGGER.info("Start SAX parsing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        switch (localName) {
            case PRECIOUS:
                currentGem = new Precious();
                setAttributes(attributes, currentGem);
                break;
            case SEMIPRECIOUS:
                currentGem = new Semiprecious();
                setAttributes(attributes, currentGem);
                break;
        }
        if (INFO_TAGS.contains(localName)){
            tag = localName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if (PRECIOUS.equals(localName) || SEMIPRECIOUS.equals(localName)) {
            gems.add(currentGem);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length){
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
    public void endDocument(){
        LOGGER.info("SAX parsing is complete");
    }

    private void setAttributes(Attributes attributes, Gem currentGem){
        final String ID = "id";
        final String AMOUNT = "amount";
        currentGem.setId(attributes.getValue(ID));
        if (attributes.getLength() == 2) {
            String value = attributes.getValue(AMOUNT);
            currentGem.setAmount(Integer.parseInt(value));
        }
    }
}
