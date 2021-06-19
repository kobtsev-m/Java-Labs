package game;

import globals.*;
import commands.CommandsParser;
import view.View;

import org.apache.log4j.Logger;

public class Game {

    private static final Logger LOGGER = Logger.getLogger(Game.class);
    public static String HELLO_MSG = "Hello! This is Logo world console app.";

    private final Environment environment;
    private final View view;
    private final CommandsParser parser;
    private GameStatus status;

    /** Create game instance */
    public Game() {
        environment = new Environment();
        view = new View(environment);
        parser = new CommandsParser(environment);
        status = new GameStatus(GameStatusCode.START, HELLO_MSG);
    }
    /** Start main game cycle */
    public void start() {
        LOGGER.debug("Game start");
        View.clearScreen();
        while (status.code != GameStatusCode.EXIT) {
            View.showMessage(status.message);
            status = parser.readCommand(new String[] {});
            View.clearScreen();
            if (environment.getIsInitialized()) {
                view.drawField();
            }
        }
        LOGGER.debug("Game end");
    }
}
