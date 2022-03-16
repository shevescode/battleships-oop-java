package com.codecool.battleship.view;

import com.codecool.battleship.model.Board;
import com.codecool.battleship.model.Spot;

public class ConsoleView {

    public void printBoard(Board board) {
        printBoardSigns();
        printLine();
        int counter = 1;
        for (Spot[] spotsRow: board.getSpotArray()) {
            if (counter == 10) {
                System.out.print(counter + "| ");
            } else {
                System.out.print(" " + counter + "| ");
            }
            for (Spot spot: spotsRow) {
                if(spot.isEmpty()) {
//                    System.out.print(spot.getSign());
                    System.out.print(" ");
                } else {
                    System.out.print("X");
                }
                System.out.print(" ");
            }
                System.out.print("|");

            System.out.println();
            counter += 1;
        }
        printLine();
        printBoardSigns();
    }

    private void printBoardSigns() {
        System.out.print("    ");
        char[] abc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int j = 0; j < 10; j++) {
            System.out.print(abc[j]+" ");
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
