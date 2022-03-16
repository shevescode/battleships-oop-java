package com.codecool.battleship.model;

import com.codecool.battleship.model.Ships.Ship;
import com.codecool.battleship.model.Ships.ShipPart;

public class Spot {

    private boolean empty;
    private final char sign;
    private Coordinates coordinates;
    private ShipPart shipPart;

    public Spot(Coordinates coordinates) {
        this.empty = true;
        this.sign = '~';
        this.coordinates = coordinates;
        this.shipPart = null;
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

    public void setShipPart(ShipPart shipPart) {
        this.shipPart = shipPart;
    }
}
