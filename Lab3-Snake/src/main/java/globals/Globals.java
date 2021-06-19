package globals;

import utils.Coords;

public class Globals {
    public static int WIDTH = 450;
    public static int HEIGHT = 450;
    public static int OFFSET_X = 300;
    public static int OFFSET_Y = 300;
    public static int TITLE_H = 25;
    public static int DOT_SIZE = 25;
    public static int DOTS_X = WIDTH / DOT_SIZE;
    public static int DOTS_Y = HEIGHT / DOT_SIZE;
    public static int DOTS_TOTAl = DOTS_X * DOTS_Y;
    public static int START_LENGTH = 3;
    public static Coords START_COORDS = new Coords(4 * DOT_SIZE, 4 * DOT_SIZE);
    public static String SCORES_FILE_PATH = "scores/scores.txt";
    public static String DEFAULT_USERNAME = "Steve";
}
