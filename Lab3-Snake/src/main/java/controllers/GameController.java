package controllers;

import models.GameSession;
import utils.Listener;
import views.GameView;

public class GameController implements Listener {

    private final WindowController windowController;
    private final ScoresController scoresController;

    private final GameSession session;
    private final GameView view;

    public GameController(WindowController windowController, ScoresController scoresController) {
        this.windowController = windowController;
        this.scoresController = scoresController;
        this.session = new GameSession();
        this.view = new GameView(this);
        session.events.subscribe("update", this);
    }
    public GameView getView() {
        return view;
    }
    public void start() {
        session.user = windowController.getUser();
        session.open();
        view.init(session);
    }
    public void stop() {
        session.close();
        windowController.showScreen("endScreen");
        scoresController.saveScore(
            session.user.getUsername(),
            session.getTotalScore()
        );
    }
    @Override
    public void handleEvent(String eventType) {
        if (eventType.equals("update")) {
            view.repaint();
        }
    }
}
