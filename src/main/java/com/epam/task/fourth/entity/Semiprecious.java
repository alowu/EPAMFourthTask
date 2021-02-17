package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;


public class Semiprecious extends Gem {

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

    @XmlElement(name = "transparency")
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
