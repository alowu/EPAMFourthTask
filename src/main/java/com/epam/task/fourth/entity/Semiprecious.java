package com.epam.task.fourth.entity;

public class Semiprecious extends Gems {
    private int transparency;

    public Semiprecious(String id, String name, Colors color, int value,
                        int amount, int transparency) {
        super(id, name, color, value, amount);
        this.transparency = transparency;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    @Override
    public String toString() {
        return "Semiprecious{" +
                "transparency=" + transparency +
                "} " + super.toString();
    }
}
