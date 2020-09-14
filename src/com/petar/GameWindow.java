package com.petar;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        initializeGame();
    }

    private void initializeGame() {
        // Add to the JFrame what to be rendered
        add(new Game(800, 800));
        pack();
        setResizable(false);
        setTitle("Snake Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
