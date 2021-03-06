package commands;

import game.*;
import globals.*;

public class Draw extends Command {
    public Draw(Environment environment) {
        super(environment);
    }
    @Override
    public GameStatus execute() {
        if (!environment.getIsInitialized()) {
            String errorMsg = "Please, execute init command first";
            return new GameStatus(GameStatusCode.ERROR, errorMsg);
        }

        LOGGER.debug("Settings drawing mode to [true]");

        environment.robot.setMode(true);

        return new GameStatus(GameStatusCode.SUCCESS, "Success!");
    }
}
