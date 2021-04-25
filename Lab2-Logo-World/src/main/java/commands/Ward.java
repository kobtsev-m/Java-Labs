package commands;

import game.*;
import globals.*;

public class Ward extends Command {
    public Ward(Environment environment) {
        super(environment);
    }
    @Override
    public GameStatus execute() {
        if (!environment.getIsInitialized()) {
            String errorMsg = "Please, execute init command first";
            return new GameStatus(GameStatusCode.ERROR, errorMsg);
        }

        LOGGER.debug("Settings drawing mode to [false]");

        environment.robot.setMode(false);

        return new GameStatus(GameStatusCode.SUCCESS, "Success!");
    }
}
