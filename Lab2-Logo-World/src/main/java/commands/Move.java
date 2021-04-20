package commands;

import game.*;
import globals.*;
import utils.*;

public class Move extends Command {
    public Move(Game game) {
        super(game);
    }
    @Override
    public GameStatus execute() {
        if (game.getIsNotInitialized()) {
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

        LOGGER.debug(String.format(
            "Moving robot to [%d, %d] with step [%d], drawing - [%b]",
            diffCoords.x, diffCoords.y, step, game.robot.getMode()
        ));

        Coords robotCoords = game.robot.getCoords();
        Coords newCoords = robotCoords.add(diffCoords.mul(step));
        game.robot.setCoords(newCoords);

        if (game.robot.getMode()) {
            int min_i, max_i;
            min_i = Math.min(0, diffCoords.x);
            max_i = Math.max(0, diffCoords.x);
            for (int i = min_i; i <= max_i; ++i) {
                game.field.setCell(robotCoords.add(new Coords(i, 0)), true);
            }
            min_i = Math.min(0, diffCoords.y);
            max_i = Math.max(0, diffCoords.y);
            for (int i = min_i; i <= max_i; ++i) {
                game.field.setCell(robotCoords.add(new Coords(0, i)), true);
            }
        }

        return new GameStatus(GameStatusCode.SUCCESS, "Success!");
    }
}
