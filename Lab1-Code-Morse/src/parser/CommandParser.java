package parser;

import morse.Coder;
import utils.FileUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandParser {

    private List<String> possibleCommands = Arrays.asList("code", "decode");
    private List<String> possibleLanguages = Arrays.asList("en", "ru");

    public CommandParser() {
        System.out.print("Please, write command in format: ");
        System.out.print("<code/decode> <filename> <lang: ru, en>\n");
    }
    public void readCommand() {
        Scanner scanner = new Scanner(System.in);
        String[] args =  scanner.nextLine().split(" ");

        if (args.length != 3) {
            System.out.println("Wrong arguments number, please, try again");
            readCommand();
        }
        else if (!possibleCommands.contains(args[0])) {
            System.out.println("Wrong command, please, try again");
            readCommand();
        }
        else if (!(new FileUtils(args[1]).isFileExists())) {
            System.out.println("File doesn't exist, please, try again");
            readCommand();
        }
        else if (!possibleLanguages.contains(args[2])) {
            System.out.println("Incorrect language, please, try again");
            readCommand();
        }
        else {
            Coder c = new Coder(args[0], args[1], args[2]);
            c.code();
            c.writeStatistic();
        }
    }
}
