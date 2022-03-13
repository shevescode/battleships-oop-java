package com.codecool.battleship.model;

import com.codecool.battleship.model.Ships.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Ship> ships;
    private Board playerBoard;
    private Board shootingBoard;

    public Player() {
        ships = new ArrayList<>();
        playerBoard = new Board();
        assignShips();
    }

    private void assignShips() {
        this.ships.add(new Carrier()); // size 5
        this.ships.add(new Battleship()); // size 4
        this.ships.add(new Cruiser()); // size 3
        this.ships.add(new Submarine()); // size 3
        this.ships.add(new Destroyer()); // size 2
    }


    public Ship chooseShip(int i) {
        return ships.get(i);
    }

    public Spot chooseSpot(Coordinates coordinates) {
        return playerBoard.getSpotArray()[coordinates.getX()][coordinates.getY()];
    }

    public void placeShip(Ship ship, Orientation orientation, Spot spot) {

    }





}
