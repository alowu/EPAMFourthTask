package com.epam.task.fourth.parser;

import com.epam.task.fourth.parser.dom.DomParser;
import com.epam.task.fourth.parser.sax.SaxParser;

public class ParserFactory {
    private enum ParserType {
        SAX,
        DOM
    }

    public AbstractParser create(String nameParser){
        ParserType type = ParserType.valueOf(nameParser.toUpperCase());
        switch (type) {
            case SAX:
                return new SaxParser();
            case DOM:
                return new DomParser();
            default:
                throw new EnumConstantNotPresentException(
                        type.getDeclaringClass(), type.name()
                );
        }
    }
}
