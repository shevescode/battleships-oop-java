package com.codecool.battleship.model;

public class Spot {

    private boolean empty;

    public Spot() {
        this.empty = true;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

}
