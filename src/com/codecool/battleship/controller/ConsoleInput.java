package com.codecool.battleship.controller;

import com.codecool.battleship.model.Coordinates;
import com.codecool.battleship.model.Ships.Orientation;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public Coordinates getCoordinates() {
        Scanner scanner = new Scanner(System.in);
        String chosenCoordinates = scanner.next();

        if (validUserInput(chosenCoordinates)) {
            int row = Character.getNumericValue(chosenCoordinates.charAt(0)) - 10;
            int colFirstDigit = Character.getNumericValue(chosenCoordinates.charAt(1));


            switch (chosenCoordinates.length()) {
                case 2 -> {
                    return new Coordinates(row, colFirstDigit - 1);
                }
                case 3 -> {
                    int colSecondDigit = Character.getNumericValue(chosenCoordinates.charAt(2));
                    String addedDigits = (colFirstDigit) + "" + (colSecondDigit);
                    int col = Integer.parseInt(addedDigits);
                    System.out.println("row = " + row + " " + "col = " + col);
                    return new Coordinates(row, col - 1);
                }
            }
        }
        return new Coordinates(0, 0);
    }

    private boolean validUserInput(String chosenCoordinates) {
        char isCharValid = chosenCoordinates.charAt(0);
        char isFirstDigitValid = chosenCoordinates.charAt(1);

        switch (chosenCoordinates.length()) {
            case 2 -> {
                if (Character.toString(isCharValid).matches("^[a-jA-J]*$")) {
                    return Character.toString(isFirstDigitValid).matches("^[1-9]*$");
                }
                return false;
            }
            case 3 -> {
                char isSecondDigitValid = chosenCoordinates.charAt(2);
                String addedDigits = String.valueOf(isFirstDigitValid) + String.valueOf(isSecondDigitValid);
                int row = Integer.parseInt(addedDigits);
                if (Character.toString(isCharValid).matches("^[a-jA-J]*$")) {
                    return row > 0 && row <= 10;

                }
                return false;
            }
            default -> {
                System.out.println("Something wrong, try again...");
                return false;
            }
        }
    }

    public Orientation getOrientation() {
        Scanner scanner = new Scanner(System.in);
        int chosenOrientation = scanner.nextInt();
        switch (chosenOrientation) {
            case 1 -> {
                return Orientation.NORTH;
            }
            case 2 -> {
                return Orientation.EAST;
            }
            case 3 -> {
                return Orientation.SOUTH;
            }
            default -> {
                return Orientation.WEST;
            }
        }
    }

    public int chooseMenuOption() {
        return scanner.nextInt();
    }
}
