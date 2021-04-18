package commands;

import game.*;
import utils.*;
import globals.*;

import java.util.Map;
import java.util.Scanner;

public class CommandsParser {

    private static final String CMD_SPLIT_REGEX = "\\s+";

    private final CommandsFactory commandsFactory;
    private final Map<String, Integer> commandsArgs;

    public CommandsParser(Game game) throws CustomException {
        this.commandsFactory = new CommandsFactory(game);
        this.commandsArgs = commandsFactory.getCommandsArgsMap();
    }
    public GameStatus readCommand() {
        Scanner scanner = new Scanner(System.in);
        String[] args =  scanner.nextLine().split(CMD_SPLIT_REGEX);
        GameStatus status = new GameStatus(GameStatusCode.ERROR, "");

        if (args.length == 0) {
            status.message = "Command string is empty, please, try again";
        }
        else if (!commandsArgs.containsKey(args[0].toLowerCase())) {
            status.message = "Wrong command, please, try again";
        }
        else if (commandsArgs.get(args[0].toLowerCase()) != args.length - 1) {
            status.message = "Wrong arguments number, please, try again";
        }
        else {
            try {
                Command cmd = commandsFactory.getCommandInstance(args);
                status = cmd.execute();
            }
            catch (NumberFormatException | CustomException e) {
                System.out.println("Incorrect argument(s), please, try again");
            }
        }
        return status;
    }
}
