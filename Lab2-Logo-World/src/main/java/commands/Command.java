package commands;

import game.*;
import globals.*;
import utils.CustomException;

import org.apache.log4j.Logger;

public abstract class Command {
    protected static final Logger LOGGER = Logger.getLogger(Command.class);
    protected String[] args;
    protected Game game;
    public Command(Game game) {
        this.game = game;
    }
    public void init(String[] args) {
        this.args = args;
    }
    public abstract GameStatus execute() throws CustomException;
}
