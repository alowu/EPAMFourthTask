package com.epam.task.fourth.parser;

import com.epam.task.fourth.validator.XmlException;

public class JaxbParserTest extends AbstractParserTest {
    private final AbstractParser parser = parserFactory.create("jaxb");

    public JaxbParserTest() throws ParserTypeException {
    }

    @Override
    public void testParseShouldParseValidXmlFileInList() throws XmlException {
        setParser(parser);
        super.testParseShouldParseValidXmlFileInList();
    }

    @Override
    public void testParseShouldThrowExceptionWhenXmlInvalid() throws XmlException {
        setParser(parser);
        super.testParseShouldThrowExceptionWhenXmlInvalid();
    }
}
