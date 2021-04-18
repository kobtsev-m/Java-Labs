package commands;

import game.*;
import globals.*;
import utils.*;

public class Init extends Command {
    public Init(Game game) {
        super(game);
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
        game.init(fieldSize, robotCoords);
        return new GameStatus(GameStatusCode.SUCCESS, "Success!");
    }
}
