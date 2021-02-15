package com.epam.task.fourth.parser.stax;

import com.epam.task.fourth.entity.Gems;
import com.epam.task.fourth.entity.Precious;
import com.epam.task.fourth.entity.Semiprecious;
import com.epam.task.fourth.parser.AbstractParser;
import com.epam.task.fourth.validator.XmlException;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaxParser extends AbstractParser {
    private final Logger LOGGER = Logger.getLogger(StaxParser.class);
    private List<Gems> gems = new ArrayList<>();
    private XMLInputFactory inputFactory;

    private final String PRECIOUS = "precious";
    private final String SEMIPRECIOUS = "semiprecious";
    private final String NAME = "name";
    private final String COLOR = "color";
    private final String VALUE = "value";
    private final String TRANSPARENCY = "transparency";
    private final String EDGES = "edges";

    public StaxParser() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<Gems> getGems() {
        return gems;
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private Semiprecious parseSemiprecious(XMLStreamReader reader) throws XMLStreamException {
        Semiprecious semi = new Semiprecious();

        semi.setId(reader.getAttributeValue(null, "id"));
        String amount = reader.getAttributeValue(null, "amount");

        if (amount == null) {
            amount = "0";
        }
        semi.setAmount(Integer.parseInt(amount));

        String name = null;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case NAME:
                            semi.setName(getXMLText(reader));
                            break;
                        case COLOR:
                            semi.setColor(getXMLText(reader));
                            break;
                        case VALUE:
                            name = getXMLText(reader);
                            semi.setValue(Integer.parseInt(name));
                            break;
                        case TRANSPARENCY:
                            name = getXMLText(reader);
                            semi.setTransparency(Integer.parseInt(name));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals(SEMIPRECIOUS)) {
                        return semi;
                    }
                    break;
            }
        }
        LOGGER.error("<" + name + "> no such tag");
        throw new XMLStreamException("Unknown element in tag Semiprecious");
    }

    private Precious parsePrecious(XMLStreamReader reader) throws XMLStreamException {
        Precious pres = new Precious();

        pres.setId(reader.getAttributeValue(null, "id"));
        String amount = reader.getAttributeValue(null, "amount");

        if (amount == null) {
            amount = "0";
        }
        pres.setAmount(Integer.parseInt(amount));

        String name = null;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case NAME:
                            pres.setName(getXMLText(reader));
                            break;
                        case COLOR:
                            pres.setColor(getXMLText(reader));
                            break;
                        case VALUE:
                            name = getXMLText(reader);
                            pres.setValue(Integer.parseInt(name));
                            break;
                        case TRANSPARENCY:
                            name = getXMLText(reader);
                            pres.setTransparency(Integer.parseInt(name));
                            break;
                        case EDGES:
                            name = getXMLText(reader);
                            pres.setEdges(Integer.parseInt(name));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals(PRECIOUS)) {
                        return pres;
                    }
                    break;
            }
        }
        LOGGER.error("<" + name + "> no such tag");
        throw new XMLStreamException("Unknown element in tag Precious");
    }

    @Override
    public List<Gems> parseListGems(String xmlFile) throws XmlException {
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;

        try{
            inputStream = new FileInputStream(xmlFile);
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()){
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(PRECIOUS)) {
                        Precious pres = parsePrecious(reader);
                        gems.add(pres);
                    }
                    if (name.equals(SEMIPRECIOUS)) {
                        Semiprecious semi = parseSemiprecious(reader);
                        gems.add(semi);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            LOGGER.error("error while STAX parsing " + e.getMessage(), e);
            throw new XmlException(e.getMessage(), e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("cant close file " + xmlFile, e);
            }
        }
        return gems;
    }


}
