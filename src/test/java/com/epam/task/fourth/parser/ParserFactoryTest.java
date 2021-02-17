package com.epam.task.fourth.parser;

import com.epam.task.fourth.parser.dom.DomParser;
import com.epam.task.fourth.parser.jaxb.JaxbParser;
import com.epam.task.fourth.parser.sax.SaxParser;
import org.junit.Assert;
import org.junit.Test;

public class ParserFactoryTest {
    private ParserFactory factory = new ParserFactory();

    @Test
    public void testCreateShouldCreateSaxParser() throws ParserTypeException {
        SaxParser result = (SaxParser) factory.create("sax");

        Assert.assertEquals(SaxParser.class, result.getClass());
    }

    @Test
    public void testCreateShouldCreateJaxbParser() throws ParserTypeException {
        JaxbParser result = (JaxbParser) factory.create("jaxb");

        Assert.assertEquals(JaxbParser.class, result.getClass());
    }

    @Test
    public void testCreateShouldCreateDomParser() throws ParserTypeException {
        DomParser result = (DomParser) factory.create("dom");

        Assert.assertEquals(DomParser.class, result.getClass());
    }

    @Test(expected = ParserTypeException.class)
    public void testCreateShouldThrowException() throws ParserTypeException {
        SaxParser result = (SaxParser) factory.create("invalid");
    }
}
