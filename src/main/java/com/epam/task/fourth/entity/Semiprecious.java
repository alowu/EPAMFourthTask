package com.epam.task.fourth.entity;

import jakarta.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Precious.class})
@XmlRootElement(name="semiprecious",namespace = "http://www.example.com/gems")
public class Semiprecious extends Gem {

    @XmlElement(name = "transparency",required = true, namespace = "http://www.example.com/gems")
    private int transparency;

    public Semiprecious() {
    }


    public Semiprecious(String id, String name, String color, int value,
                        int amount, int transparency) {
        super(id, name, color, value, amount);
        this.transparency = transparency;
    }

    public Semiprecious(Gem currentGem) {
        super(currentGem.getId(),
                currentGem.getName(),
                currentGem.getColor(),
                currentGem.getValue(),
                currentGem.getAmount());
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Semiprecious that = (Semiprecious) o;
        return getTransparency() == that.getTransparency();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTransparency());
    }

    @Override
    public String toString() {
        return super.toString() +
                "transparency=" + transparency +'\n';
    }
}
