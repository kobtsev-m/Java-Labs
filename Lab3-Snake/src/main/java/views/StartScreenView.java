package views;

import controllers.WindowController;
import globals.Globals;

import javax.swing.*;
import java.awt.*;

public class StartScreenView extends JPanel {

    private final WindowController window;
    private final JTextField nicknameEntry;

    public StartScreenView(WindowController window) {
        this.window = window;
        this.nicknameEntry = new JTextField(window.getUser().getUsername());
        setLayout(null);
        setBackground(Color.decode("#7ba256"));
    }
    public void createNicknameEntry() {
        nicknameEntry.setBounds(Globals.WIDTH / 2 - 100, Globals.HEIGHT / 2 - 90, 200, 30);
        add(nicknameEntry);
    }
    public void createStartButton() {
        JButton startButton = new JButton("Start game");
        startButton.addActionListener(e -> {
            window.setUser(nicknameEntry.getText());
            window.showScreen("gameScreen");
        });
        startButton.setBounds(Globals.WIDTH / 2 - 100, Globals.HEIGHT / 2 - 50, 200, 50);
        add(startButton);
    }
    public void createScoresButton() {
        JButton scoresButton = new JButton("Show score table");
        scoresButton.addActionListener(e -> window.showScreen("scoreTableScreen"));
        scoresButton.setBounds(Globals.WIDTH / 2 - 100, Globals.HEIGHT / 2 + 10, 200, 50);
        add(scoresButton);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        createNicknameEntry();
        createStartButton();
        createScoresButton();
    }
}
