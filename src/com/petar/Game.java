package com.petar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel implements ActionListener {
    private int WINDOW_WIDTH;
    private int WINDOW_HEIGHT;
    private Timer timer;

    // Interval used for timer representing how many times it gets called (in ms)
    private final int INTERVAL = 100;

    // Sections in the window (blocks) representing where the user can move, or food can spawn
    private final int BOXES = 900;

    private Player player;


    public Game(int WINDOW_WIDTH, int WINDOW_HEIGHT) {
        this.WINDOW_WIDTH = WINDOW_WIDTH;
        this.WINDOW_HEIGHT = WINDOW_HEIGHT;
        player = new Player(BOXES);
        createGameWindow();
    }

    private void createGameWindow() {
        // Connect a listener to the game window
        addKeyListener(player);
        setBackground(Color.black);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setFocusable(true);
        startGame();
    }

    private void startGame() {
        // Set starting snake length
        player.playerBody = 3;
        for (int i = 0; i < player.playerBody; i++) {
            player.playerX[i] = 50 - i * 10;
            player.playerY[i] = 50;
        }

        // Start the timer that will listen to key events
        timer = new Timer(INTERVAL, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    // Draw the game in the window
    private void draw(Graphics g) {
        // Draw the player (snake) on the screen
        for(int i = 0; i <  player.playerBody; i++) {
            if (i == 0) {
                // Draw  the head
                g.setColor(Color.white);
                g.fillRect(player.playerX[i], player.playerY[i], 10, 10);
            } else {
                // Draw the body of the snake
                g.setColor(Color.red);
                g.fillRect(player.playerX[i], player.playerY[i], 10, 10);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Move the player
        player.move();

        // Repaint the frame
        repaint();
    }
}
