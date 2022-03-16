package com.codecool.battleship.controller;

import com.codecool.battleship.controller.ConsoleInput;
import com.codecool.battleship.model.Coordinates;
import com.codecool.battleship.model.Player;
import com.codecool.battleship.model.Ships.Orientation;
import com.codecool.battleship.model.Ships.Ship;
import com.codecool.battleship.model.Spot;
import com.codecool.battleship.view.ConsoleView;

import java.util.List;

public class Game {
    private Player player1;
    private Player player2;
    private boolean gameIsRunning;
    private final ConsoleView consoleView;
    private final ConsoleInput consoleInput;

    public Game() {
        player1 = new Player(1);
        player2 = new Player(2);
        gameIsRunning = true;
        consoleView = new ConsoleView();
        consoleInput = new ConsoleInput();
    }

    public void startGame() {
        Player player = player1;
        playerSetsShips(player);
        while (!gameIsRunning) {
            System.out.println();
        }
    }

    private void playerSetsShips(Player player) {
        Coordinates coordinates;
        Orientation orientation;
        List<Spot> validSpots;
        consoleView.printMessage(player.toString());

        for (Ship ship : player.getShips()) {
            consoleView.printMessage("Place your ship! Size: " + ship.getSize());
            consoleView.printBoard(player.getPlayerBoard());
            consoleView.askForCoordinates();
            coordinates = consoleInput.getCoordinates();
            consoleView.askForOrientation();
            orientation = consoleInput.getOrientation();
            validSpots = player.getPlayerBoard().getSpotsForShip(ship.getSize(), orientation, coordinates);
            player.placeShip(ship, validSpots);
        }
    }
}
