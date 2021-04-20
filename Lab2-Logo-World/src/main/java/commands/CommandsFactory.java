package commands;

import game.Game;
import utils.CustomException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandsFactory {

    private final Game game;

    private final Map<String, Integer> commandsArgs;
    private final Map<String, String> commandsClasses;
    private final Map<String, Command> commandsInstances;

    public CommandsFactory(Game game) throws CustomException {

        this.game = game;

        InputStream commandsFileStream = ClassLoader.getSystemResourceAsStream(
            "commands.properties"
        );
        if (commandsFileStream == null) {
            throw new CustomException("Can't find commands properties file");
        }

        Properties commandsProperties = new Properties();
        try {
            commandsProperties.load(commandsFileStream);
            commandsFileStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        commandsArgs = new HashMap<>();
        commandsClasses = new HashMap<>();
        commandsInstances = new HashMap<>();

        for (String property : commandsProperties.stringPropertyNames()) {
            String[] propertyKey = property.split("\\.");
            String propertyValue = commandsProperties.getProperty(property);
            if (propertyKey[1].equals("class")) {
                commandsClasses.put(propertyKey[0], propertyValue);
                commandsInstances.put(propertyKey[0], null);
            }
            else if (propertyKey[1].equals("args")) {
                commandsArgs.put(propertyKey[0], Integer.parseInt(propertyValue));
            }
        }
    }
    public Map<String, Integer> getCommandsArgsMap() {
        return commandsArgs;
    }
    private void createCommandInstance(String cmdName) {
        try {
            Class<?> cmdClass = Class.forName(commandsClasses.get(cmdName));
            Constructor<?> cmdCons = cmdClass.getConstructor(Game.class);
            commandsInstances.put(cmdName, (Command) cmdCons.newInstance(game));
        }
        catch (
            ClassNotFoundException |
            NoSuchMethodException |
            InvocationTargetException |
            InstantiationException |
            IllegalAccessException e
        ) {
            e.printStackTrace();
        }
    }
    public Command getCommandInstance(String[] args) {
        if (commandsInstances.get(args[0]) == null) {
            createCommandInstance(args[0]);
        }
        Command cmd = commandsInstances.get(args[0]);
        cmd.init(args);
        return cmd;
    }
}
