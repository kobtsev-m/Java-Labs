package view;

import game.Environment;
import utils.*;

public class View {

    private final Environment environment;

    /** Clear view instance */
    public View(Environment environment) {
        this.environment = environment;
    }
    /** Clear terminal */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
    /** Show command game status message */
    public static void showMessage(String msg) {
        System.out.print(msg + "\n$ ");
    }
    /** Draw field with Field data & Robot coords */
    public void drawField() {
        Size fieldSize = environment.field.getSize();
        char[][] fieldData = environment.field.getData();
        Coords robotCoords = environment.robot.getCoords();
        for (int i = 0; i < fieldSize.h; ++i) {
            for (int j = 0; j < fieldSize.w; ++j) {
                if (robotCoords.x == j && robotCoords.y == i) {
                    System.out.print("R");
                } else {
                    System.out.print(fieldData[j][i]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
