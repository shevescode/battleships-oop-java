package com.codecool.battleship.view;

import com.codecool.battleship.model.Board;
import com.codecool.battleship.model.Spot;

import java.util.List;

public class ConsoleView {

    public void printBoard(Board board) {
        printBoardSigns();
        printLine();
        int counter = 65;
        for (Spot[] spotsRow : board.getSpotArray()) {
            System.out.print((char) counter + " | ");

            for (Spot spot : spotsRow) {
                if (spot.isEmpty()) {
                    System.out.print(spot.getSign());
                } else {
                    System.out.print(spot.getShipPart().getSign());
                }
                System.out.print(" ");
            }
            System.out.print("| " + (char) counter);
            System.out.println();
            counter += 1;
        }
        printLine();
        printBoardSigns();
    }

    private void printBoardSigns() {
        System.out.print("    ");
        for (int j = 1; j <= 10; j++) {
            System.out.print(j + " ");
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

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void askForOrientation() {
        System.out.println("Choose orientation!");
        System.out.println("1 - NORTH, 2 - EAST, 3 - SOUTH, 4/DEFAULT - WEST");
    }

    public void printMenu(List<String> menuOptions) {
        for (int i = 0; i < menuOptions.size(); i++) {
            System.out.println(i + 1 + ". " + menuOptions.get(i));
        }
    }

    public void askForCoordinates() {
        System.out.println("Choose coordinates! (Example: C5):");
    }

//    public static void clearScreen() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }

}
