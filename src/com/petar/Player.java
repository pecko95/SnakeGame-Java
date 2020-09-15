package com.petar;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends KeyAdapter {
    private final int BOX_SIZE = 10;
    private String movingDirection = "RIGHT";

    public int playerBody;
    public int playerX[];
    public int playerY[];

    public Player(int BOXES) {
        this.playerX = new int[BOXES];
        this.playerY = new int[BOXES];
    }

    // Move the player around
    public void move() {

        for(int i = playerBody;  i > 0; i--) {
            playerX[i] = playerX[(i - 1)];
            playerY[i] = playerY[(i - 1)];
        }

        if (movingDirection.equals("RIGHT")) playerX[0] += BOX_SIZE;
        if (movingDirection.equals("LEFT")) playerX[0]  -= BOX_SIZE;
        if (movingDirection.equals("UP")) playerY[0] -= BOX_SIZE;
        if (movingDirection.equals("DOWN")) playerY[0] += BOX_SIZE;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) movingDirection = "LEFT";
        if (keyCode == KeyEvent.VK_RIGHT) movingDirection = "RIGHT";
        if (keyCode == KeyEvent.VK_UP) movingDirection = "UP";
        if (keyCode == KeyEvent.VK_DOWN) movingDirection = "DOWN";
    }
}
