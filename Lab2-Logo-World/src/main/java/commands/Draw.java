package commands;

import game.*;
import globals.*;

public class Draw extends Command {
    public Draw(Game game) {
        super(game);
    }
    @Override
    public GameStatus execute() {
        if (game.getIsNotInitialized()) {
            String errorMsg = "Please, execute init command first";
            return new GameStatus(GameStatusCode.ERROR, errorMsg);
        }

        LOGGER.debug("Settings drawing mode to [true]");

        game.robot.setMode(true);

        return new GameStatus(GameStatusCode.SUCCESS, "Success!");
    }
}
