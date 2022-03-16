package com.codecool.battleship.model.Ships;

import com.codecool.battleship.model.Coordinates;

public class ShipPart {
    private final Coordinates coordinates;
    private ShipPartStatus status;
    private char sign;


    public ShipPart(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.status = ShipPartStatus.ALIVE;
        this.sign = '@';
    }

    private void onHitShipPart() {
        status = ShipPartStatus.HIT;
        sign = '!';
    }

    public void setStatus(ShipPartStatus status) {
        this.status = status;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public void sunkShipPart() {
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
