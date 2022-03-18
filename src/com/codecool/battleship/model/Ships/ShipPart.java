package com.codecool.battleship.model.Ships;

public class ShipPart {
    private ShipPartStatus status;
    private char sign;


    public ShipPart() {
        this.status = ShipPartStatus.ALIVE;
        this.sign = '@';
    }

    public void markAsHit() {
        status = ShipPartStatus.HIT;
        sign = '!';
    }

    public void markAsSunk() {
        this.status = ShipPartStatus.SUNK;
        this.sign = 'X';
    }

    public ShipPartStatus getStatus() {
        return status;
    }

    public char getSign() {
        return sign;
    }
}
