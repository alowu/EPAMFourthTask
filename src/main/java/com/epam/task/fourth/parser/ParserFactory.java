package com.epam.task.fourth.parser;

import com.epam.task.fourth.parser.dom.DomParser;
import com.epam.task.fourth.parser.sax.SaxParser;
import com.epam.task.fourth.parser.stax.StaxParser;

public class ParserFactory {
    private enum ParserType {
        SAX,
        DOM,
        STAX
    }

    public AbstractParser create(String nameParser){
        ParserType type = ParserType.valueOf(nameParser.toUpperCase());
        switch (type) {
            case SAX:
                return new SaxParser();
            case DOM:
                return new DomParser();
            case STAX:
                return new StaxParser();
            default:
                throw new EnumConstantNotPresentException(
                        type.getDeclaringClass(), type.name()
                );
        }
    }
}
