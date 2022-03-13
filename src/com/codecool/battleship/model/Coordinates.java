package com.codecool.battleship.model;

public class Coordinates {
    private int xCoordinate;
    private int yCoordinate;

    public Coordinates(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public int getX() {
        return this.xCoordinate;
    }

    public int getY() {
        return this.yCoordinate;
    }

    public void setX(int x) {
        this.xCoordinate = x;
    }

    public void setY(int y) {
        this.yCoordinate = y;
    }
}
