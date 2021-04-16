package view;

public class View {

    private final int w, h;

    public View(int w, int h) {
        this.w = w;
        this.h = h;
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void drawField() {
        clearScreen();
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                System.out.print(". ");
            }
            System.out.print("\n");
        }
    }
}
