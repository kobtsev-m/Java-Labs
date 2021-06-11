package screens;

import globals.Globals;
import window.Window;

import javax.swing.*;
import java.awt.*;

public class EndScreen extends JPanel {
    public EndScreen(Window window) {
        setLayout(null);
        // Gave over text
        setBackground(Color.decode("#000000"));
        JLabel endTextLabel = new JLabel("Game over", SwingConstants.CENTER);
        endTextLabel.setForeground(Color.decode("#ffffff"));
        endTextLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        endTextLabel.setBounds(Globals.WIDTH/2 - 75, Globals.HEIGHT/2 - 60, 150, 20);
        add(endTextLabel);
        // Restart button
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> window.replaceScreen("fieldScreen"));
        restartButton.setBounds(Globals.WIDTH/2 - 75, Globals.HEIGHT/2, 150, 50);
        add(restartButton);
    }
}
