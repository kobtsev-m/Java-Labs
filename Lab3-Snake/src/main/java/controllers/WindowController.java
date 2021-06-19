package controllers;

import globals.Globals;
import models.User;
import views.*;

import javax.swing.*;
import java.util.HashMap;

public class WindowController {

    private final User user;
    private final HashMap<String, JPanel> screensMap;

    private final WindowView windowView;
    private final ScoresController scoresController;
    private final GameController gameController;

    public WindowController() {
        user = new User(Globals.DEFAULT_USERNAME);
        screensMap = new HashMap<>();
        screensMap.put("startScreen", new StartScreenView(this));
        screensMap.put("endScreen", new EndScreenView(this));
        scoresController = new ScoresController(this);
        screensMap.put("scoreTableScreen", scoresController.getView());
        gameController = new GameController(this, scoresController);
        screensMap.put("gameScreen", gameController.getView());
        windowView = new WindowView(screensMap);
        showScreen("startScreen");
    }
    public void setUser(String username) {
        user.setUsername(username);
    }
    public User getUser() {
        return user;
    }
    public void showScreen(String screenKey) {
        if (screenKey.equals("gameScreen")) {
            gameController.start();
        } else if (screenKey.equals("scoreTableScreen")) {
            scoresController.recreateScoreTable();
        }
        windowView.showScreen(screenKey);
    }
}
