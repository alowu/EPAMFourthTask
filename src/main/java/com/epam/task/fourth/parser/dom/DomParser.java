package com.epam.task.fourth.parser.dom;

import com.epam.task.fourth.entity.Gem;
import com.epam.task.fourth.entity.Precious;
import com.epam.task.fourth.entity.Semiprecious;
import com.epam.task.fourth.parser.ParsingException;
import com.epam.task.fourth.parser.XmlParser;
import com.epam.task.fourth.parser.sax.SaxParser;
import com.epam.task.fourth.validator.XmlException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements XmlParser {
    private static final Logger LOGGER = Logger.getLogger(DomParser.class);
    private final List<Gem> gems;
    private DocumentBuilder documentBuilder;

    private final String PRECIOUS = "precious";
    private final String SEMIPRECIOUS = "semiprecious";
    private final String NAME = "name";
    private final String COLOR = "color";
    private final String VALUE = "value";
    private final String TRANSPARENCY = "transparency";
    private final String EDGES = "edges";

    public DomParser(){
        this.gems = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("error configure parser " + e.getMessage(), e);
        }
    }

    private static String getElementTextContent(Element element, String name) {
        NodeList nList = element.getElementsByTagName(name);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

    private Semiprecious parseSemiprecious(Element gemElement) {
        Semiprecious semiprecious = new Semiprecious();

        semiprecious.setId(gemElement.getAttribute("id"));
        String amount = gemElement.getAttribute("amount");
        if (amount.isEmpty()) {
            amount = "0";
        }
        semiprecious.setAmount(Integer.parseInt(amount));

        String name = getElementTextContent(gemElement, NAME);
        semiprecious.setName(name);

        String color = getElementTextContent(gemElement, COLOR);
        semiprecious.setColor(color);

        int value = Integer.parseInt(getElementTextContent(gemElement, VALUE));
        semiprecious.setValue(value);

        int transparency = Integer.parseInt(getElementTextContent(gemElement, TRANSPARENCY));
        semiprecious.setTransparency(transparency);

        return semiprecious;
    }

    private Precious parsePrecious(Element gemElement) {
        Precious precious = new Precious(parseSemiprecious(gemElement));

        int edges = Integer.parseInt(getElementTextContent(gemElement, EDGES));
        precious.setEdges(edges);

        return precious;
    }

    @Override
    public List<Gem> parse(String xmlFile) throws ParsingException {
        Document doc = null;
        try {
            doc = documentBuilder.parse(xmlFile);
            Element root = doc.getDocumentElement();

            NodeList preciousList = root.getElementsByTagName(PRECIOUS);
            for (int i = 0; i < preciousList.getLength(); ++i) {
                Element preciousElement = (Element) preciousList.item(i);
                Precious precious = parsePrecious(preciousElement);
                gems.add(precious);
            }

            NodeList semipreciousList = root.getElementsByTagName(SEMIPRECIOUS);
            for (int i = 0; i < semipreciousList.getLength(); ++i) {
                Element semipreciousElement = (Element) semipreciousList.item(i);
                Semiprecious semiprecious = parseSemiprecious(semipreciousElement);
                gems.add(semiprecious);
            }
        } catch (SAXException | IOException e) {
            throw new ParsingException(e);
        }
        return gems;
    }

}
