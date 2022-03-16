package com.codecool.battleship.view;

import com.codecool.battleship.model.Board;
import com.codecool.battleship.model.Spot;

public class ConsoleView {

    public void printBoard(Board board) {
        printBoardSigns();
        printLine();
        int counter = 65;
        for (Spot[] spotsRow: board.getSpotArray()) {
            System.out.print((char) counter + " | ");

            for (Spot spot: spotsRow) {
                if(spot.isEmpty()) {
//                    System.out.print(spot.getSign());
                    System.out.print(" ");
                } else {
                    System.out.print("X");
                }
                System.out.print(" ");
            }
                System.out.print("| " +(char) counter);
            System.out.println();
            counter += 1;
        }
        printLine();
        printBoardSigns();
    }

    private void printBoardSigns() {
        System.out.print("    ");
        for (int j = 1; j <= 10; j++) {
            System.out.print(j+" ");
        }
        System.out.println();
    }

    private void printLine() {
        System.out.print("  +");
        for (int i = 0; i < 10; i++) {
            System.out.print("--");
        }
        System.out.print("-+");
        System.out.println();
    }

}
