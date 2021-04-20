import game.Game;

import utils.CustomException;

public class Main {
    public static void main(String[] args) {
        Game game;
        try {
            game = new Game();
        }
        catch (CustomException e) {
            System.out.println("Game initialize error: " + e.getMessage());
            return;
        }
        game.start();
    }
}
