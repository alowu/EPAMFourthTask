package com.epam.task.fourth.parser;

import com.epam.task.fourth.parser.jaxb.JaxbParser;

public class JaxbParserTest extends AbstractParserTest {

    @Override
    protected XmlParser getParser() {
        return new JaxbParser();
    }
}
