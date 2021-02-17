package com.epam.task.fourth.parser;

import com.epam.task.fourth.parser.dom.DomParser;
import com.epam.task.fourth.parser.jaxb.JaxbParser;
import com.epam.task.fourth.parser.sax.SaxParser;
import com.epam.task.fourth.parser.stax.StaxParser;

public class ParserFactory {

    public AbstractParser create(String nameParser) throws ParserTypeException {
        String type = nameParser.toUpperCase();
        switch (type) {
            case "SAX":
                return new SaxParser();
            case "DOM":
                return new DomParser();
            case "STAX":
                return new StaxParser();
            case "JAXB":
                return new JaxbParser();
            default:
                throw new ParserTypeException();
        }
    }
}
