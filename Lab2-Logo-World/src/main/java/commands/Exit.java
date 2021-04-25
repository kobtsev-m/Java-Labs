package commands;

import game.*;
import globals.*;

public class Exit extends Command {
    public Exit(Environment environment) {
        super(environment);
    }
    @Override
    public GameStatus execute() {
        LOGGER.debug("Exiting...");
        return new GameStatus(GameStatusCode.EXIT, "Bye Bye!");
    }
}
