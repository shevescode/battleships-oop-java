package com.codecool.battleship.model;

import com.codecool.battleship.model.Ships.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Player {
    private final List<Ship> ships;
    private final Board playerBoard;
    private final Board shootingBoard;
    private final int id;

    public Player(int id) {
        ships = new ArrayList<>();
        playerBoard = new Board();
        shootingBoard = new Board();
        this.id = id;
        assignShips();
    }

    public void placeShip(Ship ship, List<Spot> validSpots) {
        if (validSpots.size() == ship.getSize()) {
            ship.setShipParts(validSpots);
            playerBoard.setBoardSpotEmpty(validSpots);
        }
    }

    public List<Ship> getShips() {
        return ships;
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public Board getShootingBoard() {
        return shootingBoard;
    }

    public void checkPlayerShips() {
        for (Ship ship : ships) {
            ship.checkShipPartStatus();
        }
        removeSunkShip();
    }

    @Override
    public String toString() {
        return "Player " + id;
    }

    private void removeSunkShip() {
        try {
            Ship ship = ships.stream()
                    .filter(Ship::isSunk)
                    .findAny()
                    .orElse(null);
            ships.remove(ship);
        } catch (NoSuchElementException ignored) {}
    }

    private void assignShips() {
        this.ships.add(new Carrier()); // size 5
        this.ships.add(new Battleship()); // size 4
        this.ships.add(new Cruiser()); // size 3
        this.ships.add(new Submarine()); // size 3
        this.ships.add(new Destroyer()); // size 2
    }
}
