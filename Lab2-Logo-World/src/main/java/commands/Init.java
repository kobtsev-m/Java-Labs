package commands;

import game.*;
import globals.*;
import utils.*;

public class Init extends Command {
    public Init(Environment environment) {
        super(environment);
    }
    @Override
    public GameStatus execute() throws CustomException {
        Size fieldSize = new Size(
            Integer.parseInt(args[1]),
            Integer.parseInt(args[2])
        );
        Coords robotCoords = new Coords(
            Integer.parseInt(args[3]),
            Integer.parseInt(args[4])
        );
        LOGGER.debug(String.format(
            "Initializing game with [Field size %dx%d] [Robot coords (%d, %d)]",
            fieldSize.w, fieldSize.h, robotCoords.x, robotCoords.y
        ));
        environment.init(fieldSize, robotCoords);
        return new GameStatus(GameStatusCode.SUCCESS, "Success!");
    }
}
