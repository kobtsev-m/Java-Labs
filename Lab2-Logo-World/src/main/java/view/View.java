package view;

import utils.*;
import robot.Robot;
import field.Field;

public class View {

    private final Field field;
    private final Robot robot;

    /** Clear view instance */
    public View(Field field, Robot robot) {
        this.field = field;
        this.robot = robot;
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
        Size fieldSize = field.getSize();
        char[][] fieldData = field.getData();
        Coords robotCoords = robot.getCoords();
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
