package game;

import utils.*;
import globals.*;

import commands.CommandsParser;
import robot.Robot;
import field.Field;
import view.View;

public class Game {

    public static String HELLO_MSG = "Hello! This is Logo world console app.";

    public Field field = null;
    public View view = null;
    public Robot robot = null;

    private final CommandsParser parser;
    private GameStatus status;
    private boolean isInitialized;

    public Game() throws CustomException {
        parser = new CommandsParser(this);
        status = new GameStatus(GameStatusCode.START, HELLO_MSG);
        isInitialized = false;
    }
    public boolean getIsInitialized() {
        return isInitialized;
    }
    public void start() {
        View.clearScreen();
        while (status.code != GameStatusCode.EXIT) {
            View.showMessage(status.message);
            status = parser.readCommand();
            View.clearScreen();
            if (isInitialized) {
                view.drawField();
            }
        }
    }
    public void init(Size fieldSize, Coords robotCoords) throws CustomException {
        field = new Field(fieldSize);
        robot = new Robot(robotCoords);
        view = new View(field, robot);
        isInitialized = true;
    }
}
