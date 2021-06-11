package window;

import globals.Globals;
import screens.*;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private final JPanel screens;
    private final Field field;

    public Window() {
        setTitle("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Globals.WIDTH, Globals.HEIGHT + Globals.TITLE_H);
        setLocation(Globals.OFFSET_X, Globals.OFFSET_Y);
        field = new Field(this);
        screens = new JPanel(new CardLayout());
        screens.add(new StartScreen(this), "startScreen");
        screens.add(new EndScreen(this), "endScreen");
        screens.add(field, "fieldScreen");
        add(screens);
        setVisible(true);
    }
    public void replaceScreen(String screen) {
        if (screen.equals("fieldScreen")) {
            field.initGame();
        }
        CardLayout cl = (CardLayout) screens.getLayout();
        cl.show(screens, screen);
    }
}
