package com.codecool.battleship;

import com.codecool.battleship.model.Board;
import com.codecool.battleship.view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        ConsoleView consoleView = new ConsoleView();

        consoleView.printBoard(board);
    }
}
