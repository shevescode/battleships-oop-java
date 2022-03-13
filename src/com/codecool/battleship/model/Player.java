package com.codecool.battleship.model;

import com.codecool.battleship.model.Ships.*;

import java.util.List;

public class Player {
    private List<Ship> ships;
    private Board playerBoard;
    private Board shootingBoard;

    public Player() {
        assignShips();
    }

    private void assignShips() {
        this.ships.add(new Carrier());
        this.ships.add(new Battleship());
        this.ships.add(new Cruiser());
        this.ships.add(new Submarine());
        this.ships.add(new Destroyer());
    }

    public void placeShip() {

    }




}
