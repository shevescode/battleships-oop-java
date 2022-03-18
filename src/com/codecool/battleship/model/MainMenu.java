package com.codecool.battleship.model;

import com.codecool.battleship.view.ConsoleInput;
import com.codecool.battleship.controller.Game;
import com.codecool.battleship.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    public MainMenu() {
        List<String> menuOptions = new ArrayList<>();
        ConsoleView consoleView = new ConsoleView();
        ConsoleInput consoleInput = new ConsoleInput();

        menuOptions.add("Start Game");
        menuOptions.add("Exit");

        consoleView.printMenu(menuOptions);
        executeOrder(consoleInput.chooseMenuOption());
    }

    public void executeOrder(int i) {
        switch (i) {
            case 1 -> {
                Game game = new Game();
                game.startGame();
            }
            case 2 -> System.exit(0);
            default -> throw new IllegalStateException("Unexpected value: " + i);
        }
    }

}
