package com.petar;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends KeyAdapter {
    private final int BOX_SIZE = 10;
    private String movingDirection;

    public int playerBody;
    public int playerX[];
    public int playerY[];

    public Player(int BOXES) {
        this.playerX = new int[BOXES];
        this.playerY = new int[BOXES];
    }

    // Move the player around
    public void move() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);

        if (keyCode == KeyEvent.VK_LEFT) movingDirection = "LEFT";
        if (keyCode == KeyEvent.VK_RIGHT) movingDirection = "RIGHT";
        if (keyCode == KeyEvent.VK_UP) movingDirection = "UP";
        if (keyCode == KeyEvent.VK_DOWN) movingDirection = "DOWN";
    }
}
