package com.epam.task.fourth.entity;

public class GemsVisualParameters {
    private EColors color;
    private int transparency;
    private int edges;

    public GemsVisualParameters(EColors color, int transparency, int edges) {
        this.color = color;
        this.transparency = transparency;
        this.edges = edges;
    }

    public EColors getColor() {
        return color;
    }

    public void setColor(EColors color) {
        this.color = color;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "GemsVisualParameters{" +
                "color=" + color +
                ", transparency=" + transparency +
                ", edges=" + edges +
                '}';
    }
}
