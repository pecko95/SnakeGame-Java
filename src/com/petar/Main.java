package com.petar;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame gameWindow = new GameWindow();
            gameWindow.setVisible(true);
        });
    }
}
