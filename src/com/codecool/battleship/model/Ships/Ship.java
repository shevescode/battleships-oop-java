package com.codecool.battleship.model.Ships;

import com.codecool.battleship.model.Spot;

import java.util.ArrayList;
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
            ShipPart shipPart = new ShipPart(spot.getCoordinates());
            shipParts.add(shipPart);
            spot.setShipPart(shipPart);
        }
    }

    public void checkShipPartStatus() {
        if (shipParts.stream().noneMatch(part -> (part.getStatus().equals(ShipPartStatus.ALIVE)))) {
            for (ShipPart part: shipParts) {
                part.sunkShipPart();
            }
            this.sunk = true;
        }
    }

    public List<ShipPart> getShipParts() {
        return shipParts;
    }


}
