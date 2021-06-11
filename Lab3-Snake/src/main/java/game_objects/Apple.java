package game_objects;

import globals.Globals;
import utils.Coords;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;
import java.util.Random;

public class Apple {
    private final Coords coords;
    private final Image image;

    public Apple() {
        coords = new Coords();
        randomizeCoords();
        URL imagePath = Objects.requireNonNull(
            getClass().getClassLoader().getResource("img/apple.png")
        );
        Image imageNotResized = new ImageIcon(imagePath).getImage();
        image = imageNotResized.getScaledInstance(
            Globals.DOT_SIZE,
            Globals.DOT_SIZE,
            Image.SCALE_DEFAULT
        );
    }
    public Coords getCoords() {
        return coords;
    }
    public Image getImage() {
        return image;
    }
    public void randomizeCoords() {
        coords.x = new Random().nextInt(Globals.DOTS_X) * Globals.DOT_SIZE;
        coords.y = new Random().nextInt(Globals.DOTS_Y) * Globals.DOT_SIZE;
    }
}
