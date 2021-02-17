package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "gems", namespace = "http://www.example.com/gems")
@XmlSeeAlso({Precious.class, Semiprecious.class})
public class Gem {

    private List<Gem> gems = new ArrayList<>();

    public List<Gem> getGems() {
        return gems;
    }

    public void setGems(List<Gem> gems) {
        this.gems = gems;
    }

    private String id;

    private String name;

    private String color;

    private int value;

    private int amount;

    public Gem() {
    }

    public Gem(String id, String name, String color, int value, int amount) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.value = value;
        this.amount = amount;
    }

    @XmlElement(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @XmlAttribute(name = "amount")
    public int getAmount() {
        return amount;
    }

    @XmlAttribute(name = "id")
    @XmlID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "value")
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Gem gems = (Gem) o;
        return getValue() == gems.getValue()
                && getAmount() == gems.getAmount()
                && getId().equals(gems.getId())
                && getName().equals(gems.getName())
                && getColor().equals(gems.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getColor(), getValue(), getAmount());
    }

    @Override
    public String toString() {
        return  '\n'+ "id=" + id + '\n'+
                "name=" + name + '\n'+
                "color=" + color + '\n'+
                "value=" + value + '\n'+
                "amount=" + amount + '\n';
    }
}
