package commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import game.Environment;
import globals.GameStatusCode;

public class InitTest {
    @Test
    void executeStatusCheck() {
        CommandsParser commandsParser = new CommandsParser(new Environment());
        String[] args1 = new String[]{"init", "10", "10", "2", "3"};
        String[] args2 = new String[]{"init", "10", "10", "0", "-7"};
        String[] args3 = new String[]{"init", "-5", "3", "2", "3"};
        String[] args4 = new String[]{"init", "0", "0", "2", "3"};

        // Args 1
        assertEquals(
            commandsParser.readCommand(args1).code,
            GameStatusCode.SUCCESS
        );
        // Args 2
        assertEquals(
            commandsParser.readCommand(args2).code,
            GameStatusCode.SUCCESS
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
    }
}
