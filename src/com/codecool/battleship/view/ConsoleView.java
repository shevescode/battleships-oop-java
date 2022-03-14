package com.codecool.battleship.view;

import com.codecool.battleship.model.Board;
import com.codecool.battleship.model.Spot;

public class ConsoleView {

    public void printBoard(Board board) {
        for (Spot[] spotsRow: board.getSpotArray()) {
            for (Spot spot: spotsRow) {
                if(spot.isEmpty()) {
                    System.out.print(spot.getSign());
                } else {
                    System.out.print("X");
                }

                System.out.print(" ");
            }
            System.out.println();
        }

    }





}
