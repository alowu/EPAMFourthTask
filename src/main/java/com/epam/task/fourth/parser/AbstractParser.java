package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Gem;
import com.epam.task.fourth.validator.XmlException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParser {
    protected List<Gem> gems;

    public AbstractParser(List<Gem> gems) {
        this.gems = gems;
    }

    public AbstractParser() {
        gems = new ArrayList<>();
    }

    public List<Gem> getGems() {
        return gems;
    }

    abstract public List<Gem> parseListGems(String xmlFile) throws XmlException;
}
