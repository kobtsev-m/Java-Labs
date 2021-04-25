package commands;

import game.*;
import globals.*;
import utils.*;

public class Move extends Command {
    public Move(Environment environment) {
        super(environment);
    }
    @Override
    public GameStatus execute() throws CustomException {
        if (!environment.getIsInitialized()) {
            String errorMsg = "Please, execute init command first";
            return new GameStatus(GameStatusCode.ERROR, errorMsg);
        }

        int step = Integer.parseInt(args[2]);
        Direction dir = new Direction();
        Coords diffCoords = dir.getCoords(args[1]).mul(step);

        if (diffCoords.x == 0 && diffCoords.y == 0) {
            String errorMsg = "Incorrect direction, please, try again";
            return new GameStatus(GameStatusCode.ERROR, errorMsg);
        }

        LOGGER.debug(String.format(
            "Moving robot to [%d, %d] with step [%d], drawing - [%b]",
            diffCoords.x, diffCoords.y, step, environment.robot.getMode()
        ));

        Coords robotCoords = environment.robot.getCoords();
        environment.robot.setCoords(robotCoords.add(diffCoords));

        if (environment.robot.getMode()) {
            int min_i, max_i;
            min_i = Math.min(0, diffCoords.x);
            max_i = Math.max(0, diffCoords.x);
            for (int i = min_i; i <= max_i; ++i) {
                environment.field.setCell(robotCoords.add(new Coords(i, 0)), true);
            }
            min_i = Math.min(0, diffCoords.y);
            max_i = Math.max(0, diffCoords.y);
            for (int i = min_i; i <= max_i; ++i) {
                environment.field.setCell(robotCoords.add(new Coords(0, i)), true);
            }
        }

        return new GameStatus(GameStatusCode.SUCCESS, "Success!");
    }
}
