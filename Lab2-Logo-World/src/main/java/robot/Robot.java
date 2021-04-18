package robot;

import utils.Coords;

public class Robot {
    private Coords coords;
    private boolean drawingMode;

    public Robot(Coords coords) {
        this.coords = coords;
        this.drawingMode = false;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }
    public void setMode(boolean drawingMode) {
        this.drawingMode = drawingMode;
    }
    public Coords getCoords() {
        return coords;
    }
    public boolean getMode() {
        return drawingMode;
    }
}
