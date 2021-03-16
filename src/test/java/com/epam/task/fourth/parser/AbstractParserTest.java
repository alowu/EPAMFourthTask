package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Gem;
import com.epam.task.fourth.entity.Precious;
import com.epam.task.fourth.entity.Semiprecious;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractParserTest {
    private XmlParser parser;

    private final String VALID_FILE = "inputData/gems.xml";
    private final String INVALID_FILE = "inputData/g.xml";

    private final List<Gem> EXPECTED = Arrays.asList(
            new Precious("p01", "diamond", "white", 150, 0, 80, 10),
            new Precious("p02", "ruby", "red", 100, 5, 100, 15),
            new Semiprecious("s01", "apatite", "blue", 70, 0, 70),
            new Semiprecious("s02", "prehnite", "green", 200, 10, 50));

    protected abstract XmlParser getParser();

    @Before
    public void init() {
        parser = getParser();
    }

    @Test
    public void testParseShouldParseValidXmlFileInList() throws ParsingException {
        List<Gem> result = parser.parse(VALID_FILE);

        Assert.assertEquals(EXPECTED, result);
    }

    @Test(expected = ParsingException.class)
    public void testParseShouldThrowExceptionWhenXmlInvalid() throws ParsingException {
        parser.parse(INVALID_FILE);
    }
}
