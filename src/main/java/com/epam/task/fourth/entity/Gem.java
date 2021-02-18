package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement(name = "gem", namespace = "http://www.example.com/gems")
@XmlSeeAlso({Semiprecious.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Gem {

    @XmlAttribute(name = "id",required = true)
    private String id;

    @XmlElement(name = "name",required = true, namespace = "http://www.example.com/gems")
    private String name;

    @XmlElement(name = "color",required = true, namespace = "http://www.example.com/gems")
    private String color;

    @XmlElement(name = "value",required = true, namespace = "http://www.example.com/gems")
    private int value;

    @XmlAttribute(name = "amount")
    private int amount;

    public Gem() {}

    public Gem(String id, String name, String color, int value, int amount) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.value = value;
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
