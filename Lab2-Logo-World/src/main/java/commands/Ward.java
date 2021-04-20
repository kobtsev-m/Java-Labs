package commands;

import game.*;
import globals.*;

public class Ward extends Command {
    public Ward(Game game) {
        super(game);
    }
    @Override
    public GameStatus execute() {
        if (game.getIsNotInitialized()) {
            String errorMsg = "Please, execute init command first";
            return new GameStatus(GameStatusCode.ERROR, errorMsg);
        }

        LOGGER.debug("Settings drawing mode to [false]");

        game.robot.setMode(false);

        return new GameStatus(GameStatusCode.SUCCESS, "Success!");
    }
}
