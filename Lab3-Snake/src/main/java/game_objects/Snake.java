package game_objects;

import globals.Globals;
import utils.*;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class Snake {
    public Direction direction;
    private int length;
    private final Coords[] coords;
    private final Image image;

    public Snake(Coords startCoords) {
        length = 3;
        coords = new Coords[Globals.DOTS_TOTAl];
        for (int i = 0; i < Globals.DOTS_TOTAl - 1; ++i) {
            if (i < length) {
                int diffX = -i * Globals.DOT_SIZE;
                coords[i] = startCoords.add(new Coords(diffX, 0));
            } else {
                coords[i] = new Coords();
            }
        }
        URL imagePath = Objects.requireNonNull(
            getClass().getClassLoader().getResource("img/snake_dot.png")
        );
        Image imageNotResized = new ImageIcon(imagePath).getImage();
        image = imageNotResized.getScaledInstance(
            Globals.DOT_SIZE,
            Globals.DOT_SIZE,
            Image.SCALE_DEFAULT
        );
    }
    public Coords getCoords(int i) {
        if (i < 0 || i > Globals.DOTS_TOTAl) {
            return null;
        }
        return coords[i];
    }
    public int getLength() {
        return length;
    }
    public Image getImage() {
        return image;
    }
    public void enlarge() {
        length++;
    }
    public void doStep() {
        for (int i = length - 1; i > 0; --i) {
            coords[i].x = coords[i - 1].x;
            coords[i].y = coords[i - 1].y;
        }
        switch (direction) {
            case RIGHT: {
                if (coords[0].x == Globals.WIDTH - Globals.DOT_SIZE) {
                    coords[0].x = 0;
                } else {
                    coords[0].x += Globals.DOT_SIZE;
                }
                break;
            }
            case LEFT: {
                if (coords[0].x == 0) {
                    coords[0].x = Globals.WIDTH - Globals.DOT_SIZE;
                } else {
                    coords[0].x -= Globals.DOT_SIZE;
                }
                break;
            }
            case UP: {
                if (coords[0].y == 0) {
                    coords[0].y = Globals.HEIGHT - Globals.DOT_SIZE;
                } else {
                    coords[0].y -= Globals.DOT_SIZE;
                }
                break;
            }
            case DOWN: {
                if (coords[0].y == Globals.HEIGHT - Globals.DOT_SIZE) {
                    coords[0].y = 0;
                } else {
                    coords[0].y += Globals.DOT_SIZE;
                }
                break;
            }
        }
    }
}
