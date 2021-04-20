package commands;

import game.*;
import utils.*;
import globals.*;

public class Teleport extends Command {
    public Teleport(Game game) {
        super(game);
    }
    @Override
    public GameStatus execute() {
        if (game.getIsNotInitialized()) {
            String errorMsg = "Please, execute init command first";
            return new GameStatus(GameStatusCode.ERROR, errorMsg);
        }

        Coords newCoords = new Coords(
            Integer.parseInt(args[1]),
            Integer.parseInt(args[2])
        );

        LOGGER.debug(String.format(
            "Teleporting robot to [%d, %d]",
            newCoords.x, newCoords.y
        ));

        game.robot.setCoords(newCoords);

        return new GameStatus(GameStatusCode.SUCCESS, "Success!");
    }
}
