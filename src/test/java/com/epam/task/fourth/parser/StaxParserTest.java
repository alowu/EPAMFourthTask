package com.epam.task.fourth.parser;

import com.epam.task.fourth.parser.stax.StaxParser;

public class StaxParserTest extends AbstractParserTest {

    @Override
    protected XmlParser getParser() {
        return new StaxParser();
    }
}
