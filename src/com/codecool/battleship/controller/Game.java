package com.codecool.battleship.controller;

import com.codecool.battleship.model.Board;
import com.codecool.battleship.view.ConsoleInput;
import com.codecool.battleship.model.Coordinates;
import com.codecool.battleship.model.Player;
import com.codecool.battleship.model.Ships.Orientation;
import com.codecool.battleship.model.Ships.Ship;
import com.codecool.battleship.model.Spot;
import com.codecool.battleship.view.ConsoleView;

import java.util.List;

public class Game {
    private final Player player1;
    private final Player player2;
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
        //Set Ships for players
        playerSetsShips(player1);
        playerSetsShips(player2);

        Player player = player1;
        while (gameIsRunning) {
            Coordinates coordinates;
            Board enemyBoard = getAnotherPlayer(player).getPlayerBoard();
            Board playerBoard = player.getPlayerBoard();
            Board shootingBoard = player.getShootingBoard();
            Player enemyPlayer = getAnotherPlayer(player);

            consoleView.printMessage(player.toString());
            consoleView.printBoard(playerBoard);
            consoleView.printBoard(shootingBoard);
            coordinates = consoleInput.getCoordinates();
            if (enemyBoard.isHit(coordinates)) {
                enemyBoard.getSpot(coordinates).getShipPart().markAsHit();
                enemyPlayer.checkPlayerShips();
                shootingBoard.markHit(coordinates, enemyBoard);
            } else {
                shootingBoard.markMiss(coordinates);
            }

            doesEnemyLose(enemyPlayer);
            if(gameIsRunning){
                consoleView.printBoard(playerBoard);
                consoleView.printBoard(shootingBoard);
                consoleInput.pressAnyKeyToContinue();
                player = getAnotherPlayer(player);
            } else {
                consoleView.printBoard(shootingBoard);
                consoleView.printCongratulations(player);
            }
        }
    }

    private void doesEnemyLose(Player enemyPlayer) {
        if(enemyPlayer.getShips().isEmpty()){
            gameIsRunning = false;
        }
    }

    private Player getAnotherPlayer(Player player) {
        return player.equals(player1) ? player2 : player1;
    }

    private void playerSetsShips(Player player) {
        Coordinates coordinates;
        Orientation orientation;
        List<Spot> validSpots;

        consoleView.printMessage(player.toString());
        for (Ship ship : player.getShips()) {
            consoleView.printMessage("Place your " + ship + "! Size: " + ship.getSize());
            consoleView.printBoard(player.getPlayerBoard());
            coordinates = consoleInput.getCoordinates();
            consoleView.askForOrientation();
            orientation = consoleInput.getOrientation();
            validSpots = player.getPlayerBoard().getSpotsForShip(ship.getSize(), orientation, coordinates);
            player.placeShip(ship, validSpots);
        }
        consoleView.printBoard(player.getPlayerBoard());
        consoleInput.pressAnyKeyToContinue();
    }
}
