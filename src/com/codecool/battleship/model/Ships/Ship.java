package com.codecool.battleship.model.Ships;

public abstract class Ship {
    private final int size;
//    private Orientation orientation;

    public Ship(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

//    public void setOrientation(Orientation orientation) {
//        this.orientation = orientation;
//    }
}
