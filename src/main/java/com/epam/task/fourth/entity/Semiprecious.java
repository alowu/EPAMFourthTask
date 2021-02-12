package com.epam.task.fourth.entity;

public class Semiprecious extends Natural {
    private final EPreciousness type = EPreciousness.SEMIPRECIOUS;

    public Semiprecious(int id, String name, GemsVisualParameters visualParameters,
                        int value, int amount, String origin) {
        super(id, name, visualParameters, value, amount, origin);
    }

    public EPreciousness getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Semiprecious{" +
                "type=" + type +
                "} " + super.toString();
    }
}
