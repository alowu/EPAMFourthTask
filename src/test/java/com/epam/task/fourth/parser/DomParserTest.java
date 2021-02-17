package com.epam.task.fourth.parser;

import com.epam.task.fourth.parser.AbstractParser;
import com.epam.task.fourth.parser.AbstractParserTest;
import com.epam.task.fourth.validator.XmlException;

public class DomParserTest extends AbstractParserTest {
    private final AbstractParser parser = parserFactory.create("dom");

    public DomParserTest() throws ParserTypeException {
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
