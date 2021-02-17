package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Gem;
import com.epam.task.fourth.entity.Precious;
import com.epam.task.fourth.entity.Semiprecious;
import com.epam.task.fourth.validator.XmlException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractParserTest {
    private AbstractParser parser;
    protected final ParserFactory parserFactory = new ParserFactory();
    private final String VALID_FILE = "inputData/gems.xml";
    private final String INVALID_FILE = "inputData/g.xml";

    private final List<Gem> EXPECTED = Arrays.asList(
            new Precious("p01", "diamond", "white", 150, 0, 80, 10),
            new Precious("p02", "ruby", "red", 100, 5, 100, 15),
            new Semiprecious("s01", "apatite", "blue", 70, 0, 70),
            new Semiprecious("s02", "prehnite", "green", 200, 10, 50));

    public void setParser(AbstractParser parser) {
        this.parser = parser;
    }

    @Test
    public void testParseShouldParseValidXmlFileInList() throws XmlException {
        List<Gem> result = parser.parseListGems(VALID_FILE);

        Assert.assertEquals(EXPECTED, result);
    }

    @Test(expected = XmlException.class)
    public void testParseShouldThrowExceptionWhenXmlInvalid() throws XmlException {
        parser.parseListGems(INVALID_FILE);
    }
}
