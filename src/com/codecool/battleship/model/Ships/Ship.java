package com.codecool.battleship.model.Ships;

import com.codecool.battleship.model.Coordinates;
import com.codecool.battleship.model.Spot;

import java.util.HashMap;
import java.util.List;

public abstract class Ship {
    private final int size;
    private final boolean ALIVE = true;
    private final boolean DEAD = false;
    private HashMap<Coordinates, Boolean> shipParts;

//    private Orientation orientation;

    public Ship(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setShipParts(List<Spot> spots) {
        shipParts = new HashMap<>();
        for (Spot spot: spots) {
            shipParts.put(spot.getCoordinates(), ALIVE);
        }

    }

    //    public void setOrientation(Orientation orientation) {
//        this.orientation = orientation;
//    }
}
