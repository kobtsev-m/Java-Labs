package screens;

import globals.Globals;
import window.Window;

import javax.swing.*;

public class StartScreen extends JPanel {
    public StartScreen(Window window) {
        setLayout(null);
        JButton startButton = new JButton("Start game");
        startButton.addActionListener(e -> window.replaceScreen("fieldScreen"));
        startButton.setBounds(Globals.WIDTH/2 - 75, Globals.HEIGHT/2 - 30, 150, 50);
        add(startButton);
    }
}
