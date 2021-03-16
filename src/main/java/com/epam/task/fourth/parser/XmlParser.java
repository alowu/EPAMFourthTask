package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Gem;

import java.util.List;

public interface XmlParser {
    List<Gem> parse(String fileName) throws ParsingException;
}
