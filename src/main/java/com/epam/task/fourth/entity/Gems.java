package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Objects;

@XmlRootElement(name="gems", namespace = "http://www.example.com/gems")
@XmlAccessorType(XmlAccessType.FIELD)
public class Gems {
    @XmlElements({
            @XmlElement(name="gem", type=Gem.class, namespace = "http://www.example.com/gems"),
            @XmlElement(name="precious", type=Precious.class, namespace = "http://www.example.com/gems"),
            @XmlElement(name="semiprecious", type=Semiprecious.class, namespace = "http://www.example.com/gems")
    })
    private ArrayList<Gem> gems = new ArrayList<>();

    public Gems(){
        super();
    }

    public ArrayList<Gem> getGems() {
        return gems;
    }

    public void setGems(ArrayList<Gem> gems) {
        this.gems = gems;
    }

    public void add(Gem gem) {
        gems.add(gem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Gems gems1 = (Gems) o;
        return Objects.equals(getGems(), gems1.getGems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGems());
    }

    @Override
    public String toString() {
        return "Gems{" +
                "gems=" + gems +
                '}';
    }
}
