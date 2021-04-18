package commands;

import game.*;
import globals.*;
import utils.CustomException;

public abstract class Command {
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
