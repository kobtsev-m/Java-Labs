package commands;

import game.*;
import globals.*;
import utils.CustomException;

import org.apache.log4j.Logger;

public abstract class Command {
    protected static final Logger LOGGER = Logger.getLogger(Command.class);
    protected String[] args;
    protected Environment environment;
    public Command(Environment environment) {
        this.environment = environment;
    }
    public void init(String[] args) {
        this.args = args;
    }
    public abstract GameStatus execute() throws CustomException;
}
