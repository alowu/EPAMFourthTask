package com.epam.task.fourth.entity;

public abstract class Gems {
    private final String id;
    private String name;
    private Colors color;
    private int value;
    private int amount;

    public Gems(String id, String name, Colors color, int value, int amount) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.value = value;
        this.amount = amount;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
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
