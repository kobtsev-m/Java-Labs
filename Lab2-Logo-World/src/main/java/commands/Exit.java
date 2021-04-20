package commands;

import game.*;
import globals.*;

public class Exit extends Command {
    public Exit(Game game) {
        super(game);
    }
    @Override
    public GameStatus execute() {
        LOGGER.debug("Exiting...");
        return new GameStatus(GameStatusCode.EXIT, "Bye Bye!");
    }
}
