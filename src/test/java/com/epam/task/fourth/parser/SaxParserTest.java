package com.epam.task.fourth.parser;

public class SaxParserTest extends AbstractParserTest {

    @Override
    protected XmlParser getParser() {
        return new SaxParser();
    }
}