package com.epam.task.fourth.validator;

import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {
    private final XmlValidator validator = new XmlValidator();

    private final String XSD_FILE = "inputData/gems.xsd";
    private final String VALID_XML = "inputData/gems.xml";
    private final String INVALID_XML = "inputData/g.xml";

    @Test
    public void testXmlValidatorShouldPassWhenCorrectFile() {
        boolean result = validator.isValid(VALID_XML, XSD_FILE);

        Assert.assertTrue(result);
    }

    @Test
    public void testXmlValidatorShouldPassWhenInvalidFile() {
        boolean result = validator.isValid(INVALID_XML, XSD_FILE);

        Assert.assertFalse(result);
    }
}
