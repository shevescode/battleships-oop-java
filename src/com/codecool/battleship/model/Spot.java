package com.codecool.battleship.model;

public class Spot {

    private boolean empty;
    private char sign;

    public Spot() {
        this.empty = true;
        this.sign = '~';
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

}
