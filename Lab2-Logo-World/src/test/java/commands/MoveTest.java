package commands;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import utils.*;
import game.Game;
import globals.GameStatusCode;

public class MoveTest {
    @Test
    void executeStatusCheck() throws CustomException {
        Game game = new Game();
        CommandsParser commandsParser = new CommandsParser(game);
        game.init(new Size(10, 10), new Coords(3, 3));

        String[] args1 = new String[]{"move", "d", "3"};
        String[] args2 = new String[]{"move", "l", "-2"};
        String[] args3 = new String[]{"move", "ew", "1"};
        String[] args4 = new String[]{"move", "u"};
        String[] args5 = new String[]{"move", "r", "11"};

        // Args 1
        assertEquals(
            commandsParser.readCommand(args1).code,
            GameStatusCode.SUCCESS
        );
        assertEquals(
            game.robot.getCoords(),
            new Coords(3, 6)
        );
        // Args 2
        assertEquals(
            commandsParser.readCommand(args2).code,
            GameStatusCode.SUCCESS
        );
        assertEquals(
            game.robot.getCoords(),
            new Coords(5, 6)
        );
        // Args 3
        assertEquals(
            commandsParser.readCommand(args3).code,
            GameStatusCode.ERROR
        );
        // Args 4
        assertEquals(
            commandsParser.readCommand(args4).code,
            GameStatusCode.ERROR
        );
        // Args 5
        assertEquals(
            commandsParser.readCommand(args5).code,
            GameStatusCode.SUCCESS
        );
        assertEquals(
            game.robot.getCoords(),
            new Coords(6, 6)
        );
    }
}
