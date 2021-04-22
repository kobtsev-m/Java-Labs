package commands;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import game.Game;
import globals.GameStatusCode;

public class ExitTest {
    @Test
    void executeStatusCheck() {
        Game game = new Game();
        CommandsParser commandsParser = new CommandsParser(game);

        String[] args1 = new String[]{"exit", "someArgument"};
        String[] args2 = new String[]{"exit"};

        // Args 1
        assertEquals(
            commandsParser.readCommand(args1).code,
            GameStatusCode.ERROR
        );
        // Args 2
        assertEquals(
            commandsParser.readCommand(args2).code,
            GameStatusCode.EXIT
        );
    }
}
