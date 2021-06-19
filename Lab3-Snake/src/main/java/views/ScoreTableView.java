package views;

import controllers.ScoresController;
import controllers.WindowController;
import globals.Globals;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class ScoreTableView extends JPanel {

    private final WindowController window;
    private final ScoresController scoresController;

    public ScoreTableView(WindowController window, ScoresController scoresController) {
        this.window = window;
        this.scoresController = scoresController;
        setLayout(null);
        setBackground(Color.decode("#7ba256"));
    }
    public void createBackButton() {
        JButton backButton = new JButton("← Back to lobby");
        backButton.addActionListener(e -> window.showScreen("startScreen"));
        backButton.setBounds(10, 10, 150, 50);
        add(backButton);
    }
    public void createScoresTable() {
        Vector<Vector<String>> scoresData = scoresController.getScores();
        Vector<String> scoresHeader = new Vector<>(Arrays.asList("Nickname", "Scores"));
        JTable tb = new JTable(scoresData, scoresHeader);
        tb.setRowHeight(40);
        tb.setIntercellSpacing(new Dimension(10, 10));
        JScrollPane jsp = new JScrollPane(tb);
        jsp.getViewport().setBackground(Color.decode("#7ba256"));
        jsp.setBorder(BorderFactory.createEmptyBorder());
        jsp.setBounds(10, 70, Globals.WIDTH - 20, Globals.HEIGHT - 80);
        add(jsp);
        setVisible(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        createBackButton();
        createScoresTable();
    }
}
