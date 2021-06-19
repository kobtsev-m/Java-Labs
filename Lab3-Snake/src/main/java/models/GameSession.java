package models;

import globals.Globals;
import utils.EventManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSession implements ActionListener {

    public EventManager events;

    public Snake snake;
    public Apple apple;
    public User user;

    private boolean isActive;
    private final int delay = 120;
    private final Timer timer = new Timer(delay, this);
    private int elapsedTime;
    private double totalScore;

    public GameSession() {
        events = new EventManager("update");
    }
    public boolean getIsActive() {
        return isActive;
    }
    public double getTotalScore() {
        return totalScore;
    }

    public void open() {
        snake = new Snake(Globals.START_COORDS);
        apple = new Apple();
        elapsedTime = 0;
        totalScore = 0.0;
        isActive = true;
        timer.start();
    }
    public void close() {
        timer.stop();
    }

    private void checkForApple() {
        if (snake.getCoords(0).equals(apple.getCoords())) {
            snake.enlarge();
            apple.randomizeCoords();
            totalScore += 30000.0 / elapsedTime;
            elapsedTime = 0;
        }
    }
    private void checkForCollisions() {
        for (int i = 1; i < snake.getLength(); ++i) {
            if (snake.getCoords(0).equals(snake.getCoords(i))) {
                isActive = false;
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        elapsedTime += delay;
        checkForApple();
        checkForCollisions();
        snake.doStep();
        events.notify("update");
    }
}
