package com.codecool.battleship.model;

public class Board {
    private int size;
    private final Spot[][] board;

    public Board() {
        this.board = new Spot[10][10];
    }
}
