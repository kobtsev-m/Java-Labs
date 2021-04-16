package parser;

import commands.AbstractCommand;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Scanner;

public class CommandParser {

    private final Map<String, Integer> commands = Map.of(
        "init", 4,
        "move", 1,
        "draw", 0,
        "ward", 0,
        "teleport", 2
    );

    private String capitalize(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
    public boolean readCommand() {
        Scanner scanner = new Scanner(System.in);
        String[] args =  scanner.nextLine().split(" ");

        if (args.length < 1) {
            System.out.println("Command string is empty, please, try again");
        }
        else if (!commands.containsKey(args[0].toLowerCase())) {
            System.out.println("Wrong command, please, try again");
        }
        else if (commands.get(args[0].toLowerCase()) != args.length - 1) {
            System.out.println("Wrong arguments number, please, try again");
        }
        else {
            try {
                Class<?> cmdClass = Class.forName("commands." + capitalize(args[0]));
                Constructor<?> cmdCons = cmdClass.getConstructor(String[].class);
                AbstractCommand cmd = (AbstractCommand) cmdCons.newInstance((Object) args);
                cmd.execute();
            }
            catch (
                ClassNotFoundException |
                NoSuchMethodException |
                InvocationTargetException |
                InstantiationException |
                IllegalAccessException e)
            {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
