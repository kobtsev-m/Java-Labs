package game;

import utils.*;
import globals.*;

import commands.CommandsParser;
import robot.Robot;
import field.Field;
import view.View;

import org.apache.log4j.Logger;

public class Game {

    private static final Logger LOGGER = Logger.getLogger(Game.class);
    public static String HELLO_MSG = "Hello! This is Logo world console app.";

    public Field field = null;
    public View view = null;
    public Robot robot = null;

    private final CommandsParser parser;
    private GameStatus status;
    private boolean isInitialized;

    /** Clear terminal */
    public Game() {
        parser = new CommandsParser(this);
        status = new GameStatus(GameStatusCode.START, HELLO_MSG);
        isInitialized = false;
    }
    public boolean getIsNotInitialized() {
        return !isInitialized;
    }
    /** Start main game cycle */
    public void start() {
        LOGGER.debug("Game start");
        View.clearScreen();
        while (status.code != GameStatusCode.EXIT) {
            View.showMessage(status.message);
            status = parser.readCommand(new String[] {});
            View.clearScreen();
            if (isInitialized) {
                view.drawField();
            }
        }
        LOGGER.debug("Game end");
    }
    /**
     * Initialize game - set field size & robot coords
     *
     * @param fieldSize        Field size
     * @param robotCoords      Robot coordinates
     * @throws CustomException If Field Size is incorrect
     * */
    public void init(Size fieldSize, Coords robotCoords) throws CustomException {
        field = new Field(fieldSize);
        robot = new Robot(robotCoords, fieldSize);
        view = new View(field, robot);
        isInitialized = true;
    }
}
