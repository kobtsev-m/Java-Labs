import parser.CommandParser;

public class Main {

    public static void main(String[] args) {
        CommandParser parser = new CommandParser();
        boolean exitStatus = false;

        while (!exitStatus) {
            exitStatus = parser.readCommand();
        }
    }
}
