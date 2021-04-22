package commands;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import utils.*;
import game.Game;
import globals.GameStatusCode;

public class WardTest {
    @Test
    void executeStatusCheck() throws CustomException {
        Game game = new Game();
        CommandsParser commandsParser = new CommandsParser(game);
        game.init(new Size(10, 10), new Coords(1, 1));

        String[] args1 = new String[]{"ward", "1"};
        String[] args2 = new String[]{"ward"};

        // Args 1
        assertEquals(
            commandsParser.readCommand(args1).code,
            GameStatusCode.ERROR
        );
        assertFalse(game.robot.getMode());
        // Args 2
        game.robot.setMode(true);
        assertEquals(
            commandsParser.readCommand(args2).code,
            GameStatusCode.SUCCESS
        );
        assertFalse(game.robot.getMode());
    }
}
