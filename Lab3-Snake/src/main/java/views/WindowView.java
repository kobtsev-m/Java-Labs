package views;

import globals.Globals;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class WindowView extends JFrame {

    private final JPanel screens;

    public WindowView(Map<String, JPanel> screensMap) {
        setTitle("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Globals.WIDTH, Globals.HEIGHT + Globals.TITLE_H);
        setLocation(Globals.OFFSET_X, Globals.OFFSET_Y);
        screens = new JPanel(new CardLayout());
        for (Map.Entry<String, JPanel> entry : screensMap.entrySet()) {
            screens.add(entry.getValue(), entry.getKey());
        }
        add(screens);
        setVisible(true);
    }
    public void showScreen(String screenKey) {
        CardLayout cl = (CardLayout) screens.getLayout();
        cl.show(screens, screenKey);
    }
}
