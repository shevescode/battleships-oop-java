package com.codecool.battleship.view;

import com.codecool.battleship.model.Board;
import com.codecool.battleship.model.Spot;

public class ConsoleView {

    public void printBoard(Board board) {
        for (Spot[] spotsRow: board.getSpotArray()) {
            for (Spot spot: spotsRow) {
                System.out.print(spot.getSign());
                System.out.print(" ");
            }
            System.out.println();
        }

    }





}
