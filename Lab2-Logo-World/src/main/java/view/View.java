package view;

import robot.Robot;
import utils.*;
import field.Field;

public class View {

    private final Field field;
    private final Robot robot;

    public View(Field field, Robot robot) {
        this.field = field;
        this.robot = robot;
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
    public static void showMessage(String msg) {
        System.out.print(msg + "\n$ ");
    }
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
            System.out.print("\n");
        }
    }
}
