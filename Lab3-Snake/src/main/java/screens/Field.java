package screens;

import globals.Globals;
import game_objects.*;
import utils.*;
import window.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Field extends JPanel implements ActionListener {

    private final window.Window window;
    private Snake snake;
    private Apple apple;

    private boolean isRunning;

    private final int delay = 150;
    private final Timer timer = new Timer(delay, this);
    private int elapsedTime = 0;
    private double totalScore = 0.0;

    public Field(Window window) {
        this.window = window;
    }

    public void initGame() {
        focusOnPanel();
        removeAll();
        setBackground(Color.decode("#ffffff"));
        Coords startCoords = new Coords(4 * Globals.DOT_SIZE, 4 * Globals.DOT_SIZE);
        snake = new Snake(startCoords);
        apple = new Apple();
        snake.direction = Direction.RIGHT;
        isRunning = true;
        timer.start();
    }

    private void focusOnPanel() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                Field.this.requestFocusInWindow();
            }
        });
        setFocusable(true);
        addKeyListener(new FieldKeyListener());
    }

    private void checkForApple() {
        if (snake.getCoords(0).equals(apple.getCoords())) {
            snake.enlarge();
            apple.randomizeCoords();
            totalScore = elapsedTime * 0.01 * snake.getLength();
        }
    }

    private void checkForCollisions() {
        for (int i = 1; i < snake.getLength(); ++i) {
            if (snake.getCoords(0).equals(snake.getCoords(i))) {
                isRunning = false;
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isRunning) {
            Coords appleCoords = apple.getCoords();
            g.drawImage(apple.getImage(), appleCoords.x, appleCoords.y, this);
            for (int i = snake.getLength() - 1; i >= 0; --i) {
                Coords snakeCoords = snake.getCoords(i);
                g.drawImage(snake.getImage(), snakeCoords.x, snakeCoords.y, this);
            }
            g.setFont(new Font("Calibri", Font.BOLD, 16));
            g.drawString("Your score: " + totalScore, 10, 20);
            Toolkit.getDefaultToolkit().sync();
        } else {
            timer.stop();
            window.replaceScreen("endScreen");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkForApple();
        checkForCollisions();
        snake.doStep();
        elapsedTime += delay;
        repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_RIGHT && snake.direction != Direction.LEFT) {
                snake.direction = Direction.RIGHT;
            }
            if (keyCode == KeyEvent.VK_LEFT && snake.direction != Direction.RIGHT) {
                snake.direction = Direction.LEFT;
            }
            if (keyCode == KeyEvent.VK_UP && snake.direction != Direction.DOWN) {
                snake.direction = Direction.UP;
            }
            if (keyCode == KeyEvent.VK_DOWN && snake.direction != Direction.UP) {
                snake.direction = Direction.DOWN;
            }
        }
    }
}
