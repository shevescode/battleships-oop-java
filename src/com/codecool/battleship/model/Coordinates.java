package com.codecool.battleship.model;

public class Coordinates {
    private final int xCoordinate;
    private final int yCoordinate;

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
}
