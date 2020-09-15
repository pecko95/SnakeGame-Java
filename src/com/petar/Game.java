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
    private final int BOX_SIZE = 10;

    // To get the TOTAL number of boxes, we multiply the window's width and height, and then
    // divide by the BOX_SIZE multiplied by it self (so it can represent X and Y values of the box)
    private int BOXES;

    private Player player;

    // Food
    private int foodX;
    private int foodY;

    // We set random position to be the total number of boxes - 1 so it can range from 0 to boxes-1 value
    private int FOOD_RANDOM_POSITION;

    public Game(int WINDOW_WIDTH, int WINDOW_HEIGHT) {
        this.WINDOW_WIDTH = WINDOW_WIDTH;
        this.WINDOW_HEIGHT = WINDOW_HEIGHT;
        setBOXES();
        setFOOD_RANDOM_POSITION();
        createGameWindow();
    }

    private void createGameWindow() {
        // Connect a listener to the game window
        player = new Player(BOXES);
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

        createFood();

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
        // Draw the food
        g.setColor(Color.orange);
        g.fillRect(foodX, foodY, 10, 10);

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

    // Create the food at a random location on the frame
    private void createFood() {
        int foodRandomPosition = (int)(Math.random() * FOOD_RANDOM_POSITION);
        foodX = foodRandomPosition * BOX_SIZE;
        foodY = foodRandomPosition * BOX_SIZE;

        System.out.println("FOOD X" + foodX);
        System.out.println("FOOD Y" + foodY);
    }

    private void foodEaten() {
        if (player.playerX[0] == foodX && player.playerY[0] == foodY) {
            createFood();
            player.playerBody++;
        }
    }

    private void checkCollision() {
        // If snake hits the walls
        if (player.playerX[0] <= 0 || player.playerX[0] == WINDOW_WIDTH || player.playerY[0] <= 0 || player.playerY[0] == WINDOW_HEIGHT) {
            System.out.println("SNAKE HAS HIT THE WALL");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Move the player
        player.move();

        // Check if snake has collided with wall or itself
        checkCollision();

        // When food is eaten, generate new food
        foodEaten();

        // Repaint the frame
        repaint();
    }

    private void setBOXES() {
        BOXES = (WINDOW_WIDTH * WINDOW_HEIGHT) / (BOX_SIZE * BOX_SIZE);
    }

    private void setFOOD_RANDOM_POSITION() {
        FOOD_RANDOM_POSITION = (WINDOW_WIDTH / BOX_SIZE) - 1;
        System.out.println(FOOD_RANDOM_POSITION);
    }
}
