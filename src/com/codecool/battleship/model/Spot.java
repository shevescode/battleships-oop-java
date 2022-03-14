package com.codecool.battleship.model;

public class Spot {

    private boolean empty;
    private char sign;
    private Coordinates coordinates;

    public Spot(Coordinates coordinates) {
        this.empty = true;
        this.sign = '~';
        this.coordinates = coordinates;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public char getSign() {
        return sign;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
