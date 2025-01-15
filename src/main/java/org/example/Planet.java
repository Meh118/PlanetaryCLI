package org.example;

public class Planet {

    private String name;

    private double gravity;

    public Planet(String name, double gravity) {
        this.name = name;
        this.gravity = gravity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }
}
