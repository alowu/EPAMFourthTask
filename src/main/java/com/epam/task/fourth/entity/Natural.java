package com.epam.task.fourth.entity;

public class Natural extends Gems {
    private String origin;

    public Natural(int id, String name, GemsVisualParameters visualParameters,
                   int value, int amount, String origin) {
        super(id, name, visualParameters, value, amount);
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Natural{" +
                "origin='" + origin + '\'' +
                "} " + super.toString();
    }
}
