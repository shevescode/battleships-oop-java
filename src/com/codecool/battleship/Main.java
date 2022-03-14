package com.codecool.battleship;

import com.codecool.battleship.model.Board;
import com.codecool.battleship.model.Coordinates;
import com.codecool.battleship.model.Player;
import com.codecool.battleship.model.Ships.Orientation;
import com.codecool.battleship.model.Ships.Ship;
import com.codecool.battleship.model.Spot;
import com.codecool.battleship.view.ConsoleView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        ConsoleView consoleView = new ConsoleView();

        consoleView.printBoard(player.getPlayerBoard());
        Ship ship = player.chooseShip(1);
        List<Spot> validSpots = player.getPlayerBoard().getSpotsForShip(ship.getSize(), Orientation.SOUTH, new Coordinates(0,0));
        player.placeShip(ship, validSpots);
        System.out.println();
        consoleView.printBoard(player.getPlayerBoard());
    }
}
