package com.codecool.battleship.model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class MainMenu {
    private List<String> menuOptions;

    public MainMenu() {
        this.menuOptions = new ArrayList<>();
        menuOptions.add("Start Game");
        menuOptions.add("Exit");
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void executeOrder(int i) {
        switch (i) {
            case 1 -> {
                Game game = new Game();
            }
            case 2 -> {
                System.exit(0);
            }
        }
    }
}
