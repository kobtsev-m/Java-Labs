package views;

import controllers.GameController;
import models.*;
import utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

public class GameView extends JPanel {

    private GameSession session;
    private final GameController gameController;

    public GameView(GameController gameController) {
        this.gameController = gameController;
    }

    public void init(GameSession session) {
        this.session = session;
        focusOnPanel();
        removeAll();
        setBackground(Color.decode("#7ba256"));
    }

    private void focusOnPanel() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                GameView.this.requestFocusInWindow();
            }
        });
        setFocusable(true);
        addKeyListener(new FieldKeyListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (session.getIsActive()) {
            Coords appleCoords = session.apple.getCoords();
            g.drawImage(session.apple.getImage(), appleCoords.x, appleCoords.y, this);
            for (int i = session.snake.getLength() - 1; i >= 0; --i) {
                Coords snakeCoords = session.snake.getCoords(i);
                g.drawImage(session.snake.getImage(), snakeCoords.x, snakeCoords.y, this);
            }
            g.setFont(new Font("Calibri", Font.BOLD, 16));
            String totalScore = String.format(Locale.US, "%.1f", session.getTotalScore());
            g.drawString("Your score: " + totalScore, 10, 20);
            Toolkit.getDefaultToolkit().sync();
        } else {
            gameController.stop();
        }
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_RIGHT && session.snake.direction != Direction.LEFT) {
                session.snake.direction = Direction.RIGHT;
            }
            if (keyCode == KeyEvent.VK_LEFT && session.snake.direction != Direction.RIGHT) {
                session.snake.direction = Direction.LEFT;
            }
            if (keyCode == KeyEvent.VK_UP && session.snake.direction != Direction.DOWN) {
                session.snake.direction = Direction.UP;
            }
            if (keyCode == KeyEvent.VK_DOWN && session.snake.direction != Direction.UP) {
                session.snake.direction = Direction.DOWN;
            }
        }
    }
}
