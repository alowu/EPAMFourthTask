package com.epam.task.fourth.entity;

import java.util.Objects;

public class Precious extends Natural {
    private final EPreciousness type = EPreciousness.PRECIOUS;

    public Precious(int id, String name, GemsVisualParameters visualParameters,
                    int value, int amount, String origin) {
        super(id, name, visualParameters, value, amount, origin);
    }

    public EPreciousness getType() {
        return type;
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
        return getType() == precious.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }

    @Override
    public String toString() {
        return "Precious{" +
                "type=" + type +
                "} " + super.toString();
    }
}
