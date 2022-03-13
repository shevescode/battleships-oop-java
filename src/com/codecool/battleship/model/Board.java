package com.codecool.battleship.model;

public class Board {
    private int size;
    private Spot[][] spotArray;

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
                spotArray[i][j] = new Spot();
            }
        }

    }

}
