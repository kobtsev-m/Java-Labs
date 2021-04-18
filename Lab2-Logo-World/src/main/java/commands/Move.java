package commands;

import game.*;
import globals.Direction;
import globals.GameStatus;
import globals.GameStatusCode;
import utils.Coords;

public class Move extends Command {

    public Move(Game game) {
        super(game);
    }
    @Override
    public GameStatus execute() {
        if (!game.getIsInitialized()) {
            String errorMsg = "Please, execute init command first";
            return new GameStatus(GameStatusCode.ERROR, errorMsg);
        }

        Direction dir = new Direction();
        Coords diffCoords = dir.getCoords(args[1]);
        int step = Integer.parseInt(args[2]);

        if (diffCoords.x == 0 && diffCoords.y == 0) {
            String errorMsg = "Incorrect direction, please, try again";
            return new GameStatus(GameStatusCode.ERROR, errorMsg);
        }

        Coords robotCoords = game.robot.getCoords();
        Coords newCoords = robotCoords.add(diffCoords.mul(step));
        game.robot.setCoords(newCoords);

        return new GameStatus(GameStatusCode.SUCCESS, "Success!");
    }
}
