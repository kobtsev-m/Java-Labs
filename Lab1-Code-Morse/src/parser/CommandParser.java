package parser;

import morse.Decoder;
import morse.Encoder;
import utils.FileUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandParser {

    private final List<String> possibleCommands = Arrays.asList("code", "decode");
    private final List<String> possibleLanguages = Arrays.asList("en", "ru");

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
        else if (args[0].equals("code")) {
            Encoder encoder = new Encoder(args[1], args[2]);
            encoder.code();
            encoder.writeStatistic();
        }
        else if (args[0].equals("decode")) {
            Decoder decoder = new Decoder(args[1], args[2]);
            decoder.code();
            decoder.writeStatistic();
        }
    }
}
