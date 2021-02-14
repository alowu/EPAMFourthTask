package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Gems;
import com.epam.task.fourth.validator.XmlException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParser {
    protected List<Gems> gems;

    public AbstractParser(List<Gems> gems) {
        this.gems = gems;
    }

    public AbstractParser() {
        gems = new ArrayList<>();
    }

    public List<Gems> getGems() {
        return gems;
    }

    abstract public List<Gems> parseListGems(String xmlFile) throws XmlException;
}
