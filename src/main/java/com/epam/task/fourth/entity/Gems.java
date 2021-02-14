package com.epam.task.fourth.entity;

import java.util.Objects;

public abstract class Gems {
    private String id;
    private String name;
    private String color;
    private int value;
    private int amount;

    public Gems(){}

    public Gems(String id, String name, String color, int value, int amount) {
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
        Gems gems = (Gems) o;
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
        return "Gems{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", value=" + value +
                ", amount=" + amount +
                '}';
    }
}
