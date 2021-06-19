package views;

import controllers.WindowController;
import globals.Globals;

import javax.swing.*;
import java.awt.*;

public class EndScreenView extends JPanel {

    private final WindowController window;

    public EndScreenView(WindowController window) {
        this.window = window;
        setLayout(null);
        setBackground(Color.decode("#000000"));
    }
    public void createEndTextLabel() {
        JLabel endTextLabel = new JLabel("Game over", SwingConstants.CENTER);
        endTextLabel.setForeground(Color.decode("#ffffff"));
        endTextLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        endTextLabel.setBounds(Globals.WIDTH/2 - 75, Globals.HEIGHT/2 - 80, 150, 20);
        add(endTextLabel);
    }
    public void createRestartButton() {
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> window.showScreen("gameScreen"));
        restartButton.setBounds(Globals.WIDTH/2 - 100, Globals.HEIGHT/2 - 30, 200, 50);
        add(restartButton);
    }
    public void createBackButton() {
        JButton backButton = new JButton("Back to lobby");
        backButton.addActionListener(e -> window.showScreen("startScreen"));
        backButton.setBounds(Globals.WIDTH/2 - 100, Globals.HEIGHT/2 + 30, 200, 50);
        add(backButton);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        createEndTextLabel();
        createRestartButton();
        createBackButton();
    }
}
