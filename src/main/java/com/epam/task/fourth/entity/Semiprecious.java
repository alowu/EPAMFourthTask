package com.epam.task.fourth.entity;

public class Semiprecious extends Gems {
    private final EPreciousness type = EPreciousness.SEMIPRECIOUS;

    public Semiprecious(int id, String name, GemsVisualParameters visualParameters,
                        int value, String origin, int amount) {
        super(id, name, visualParameters, value, origin, amount);
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
