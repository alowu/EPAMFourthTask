package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;


public class Precious extends Semiprecious {

    private int edges;

    public Precious() {}

    public Precious(String id, String name, String color, int value,
                    int amount, int transparency, int edges) {
        super(id, name, color, value, amount, transparency);
        this.edges = edges;
    }

    public Precious(Semiprecious currentGem) {
        super(currentGem.getId(),
                currentGem.getName(),
                currentGem.getColor(),
                currentGem.getValue(),
                currentGem.getAmount(),
                currentGem.getTransparency());
    }

    @XmlElement(name="edges")
    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Precious precious = (Precious) o;
        return getEdges() == precious.getEdges();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEdges());
    }

    @Override
    public String toString() {
        return super.toString() +
               "edges=" + edges + '\n';
    }
}
