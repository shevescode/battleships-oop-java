package com.codecool.battleship.model;

import com.codecool.battleship.model.Ships.Orientation;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Spot[][] spotArray;

    public Board() {
        spotArray = new Spot[10][10];
        initBoard();
    }

    public Spot[][] getSpotArray() {
        return spotArray;
    }

    private void initBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                spotArray[i][j] = new Spot(new Coordinates(i, j));
            }
        }

    }

    public void setBoardSpotEmpty(List<Spot> spots) {
        for (Spot spot : spots) {
            spot.setEmpty(false);
        }
    }

    public List<Spot> getSpotsForShip(int shipSize, Orientation orientation, Coordinates coordinates) {
        List<Spot> validSpots = new ArrayList<>();
        switch (orientation) {
            case EAST -> {
                for (int i = 0; i < shipSize; i++) {
                    if (this.getSpotArray()[coordinates.getX()][coordinates.getY() + i].isEmpty()) {
                        validSpots.add(this.getSpotArray()[coordinates.getX()][coordinates.getY() + i]);
                    }
                }
            }
            case WEST -> {
                for (int i = 0; i < shipSize; i++) {
                    if (this.getSpotArray()[coordinates.getX()][coordinates.getY() - i].isEmpty()) {
                        validSpots.add(this.getSpotArray()[coordinates.getX()][coordinates.getY() - i]);
                    }
                }
            }
            case NORTH -> {
                for (int i = 0; i < shipSize; i++) {
                    if (this.getSpotArray()[coordinates.getX() - i][coordinates.getY()].isEmpty()) {
                        validSpots.add(this.getSpotArray()[coordinates.getX() - i][coordinates.getY()]);
                    }
                }
            }
            case SOUTH -> {
                for (int i = 0; i < shipSize; i++) {
                    if (this.getSpotArray()[coordinates.getX() + i][coordinates.getY()].isEmpty()) {
                        validSpots.add(this.getSpotArray()[coordinates.getX() + i][coordinates.getY()]);
                    }
                }
            }
        }
        return validSpots;
    }


}
