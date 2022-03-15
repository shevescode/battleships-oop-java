package com.codecool.battleship.model.Ships;

import com.codecool.battleship.model.Coordinates;
import com.codecool.battleship.model.Spot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Ship {
    private final int size;
    private boolean sunk;
    private List<ShipPart> shipParts;

//    private Orientation orientation;

    public Ship(int size) {
        this.size = size;
        this.sunk = false;
        this.shipParts = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public void setShipParts(List<Spot> spots) {
        for (Spot spot: spots) {
            shipParts.add(new ShipPart(spot.getCoordinates()));
        }
    }

    public void checkShipPartStatus() {
        if (!shipParts.stream()
                .anyMatch(part -> (part.getStatus().equals(ShipPartStatus.ALIVE)))) {
            for (ShipPart part: shipParts) {
                part.setStatus(ShipPartStatus.SUNK);
                part.setSign('X');
            }
        }
    }
}
