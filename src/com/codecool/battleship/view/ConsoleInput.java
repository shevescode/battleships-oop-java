package com.codecool.battleship.view;

import com.codecool.battleship.model.Coordinates;
import com.codecool.battleship.model.Ships.Orientation;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;
    private final ConsoleView consoleView;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
        this.consoleView = new ConsoleView();
    }

    public Coordinates getCoordinates() {
        String chosenCoordinates;
        Scanner scanner = new Scanner(System.in);
        do {
            consoleView.askForCoordinates();
            chosenCoordinates = scanner.next();
        } while (!validUserInput(chosenCoordinates));

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
                return new Coordinates(row, col - 1);
            }
        }
        return new Coordinates(0, 0);
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

    public void pressAnyKeyToContinue() {
        consoleView.printMessage("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }

    private boolean validUserInput(String chosenCoordinates) {
        switch (chosenCoordinates.length()) {
            case 2 -> {
                try {
                    char isCharValid = chosenCoordinates.charAt(0);
                    char isFirstDigitValid = chosenCoordinates.charAt(1);

                    if (Character.toString(isCharValid).matches("^[a-jA-J]*$")) {
                        return Character.toString(isFirstDigitValid).matches("^[1-9]*$");
                    }
                    System.out.println("Something wrong, try again...");
                    return false;
                } catch (Exception e) {
                    System.out.println("Something wrong, try again...");
                    return false;
                }

            }
            case 3 -> {
                try {
                    char isCharValid = chosenCoordinates.charAt(0);
                    char isFirstDigitValid = chosenCoordinates.charAt(1);
                    char isSecondDigitValid = chosenCoordinates.charAt(2);

                    String addedDigits = (isFirstDigitValid) + "" + (isSecondDigitValid);
                    int row = Integer.parseInt(addedDigits);
                    if (Character.toString(isCharValid).matches("^[a-jA-J]*$")) {
                        return row > 0 && row <= 10;

                    }
                    System.out.println("Something wrong, try again...");
                    return false;
                } catch (Exception e) {
                    System.out.println("Something wrong, try again...");
                    return false;
                }

            }
            default -> {
                System.out.println("Something wrong, try again...");
                return false;
            }
        }
    }
}
