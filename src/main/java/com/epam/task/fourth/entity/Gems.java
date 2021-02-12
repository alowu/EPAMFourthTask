package com.epam.task.fourth.entity;

public abstract class Gems {
    private final int Id;
    private String name;
    private GemsVisualParameters visualParameters;
    private int value;
    private int amount;

    public Gems(int id, String name, GemsVisualParameters visualParameters, int value, int amount) {
        this.Id = id;
        this.name = name;
        this.visualParameters = visualParameters;
        this.value = value;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GemsVisualParameters getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(GemsVisualParameters visualParameters) {
        this.visualParameters = visualParameters;
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
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", visualParameters=" + visualParameters +
                ", value=" + value +
                ", amount=" + amount +
                '}';
    }
}
