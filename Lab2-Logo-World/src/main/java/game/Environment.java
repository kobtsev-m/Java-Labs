package game;

import field.Field;
import robot.Robot;
import utils.*;

public class Environment {

    private boolean isInitialized;
    public Robot robot;
    public Field field;

    /** Create Environment instance and set as uninitialized */
    public Environment() {
        isInitialized = false;
    }
    /**
     * Initialize game - set field size & robot coords
     *
     * @param fieldSize        Field size
     * @param robotCoords      Robot coordinates
     * @throws CustomException If Field Size is invalid
     * */
    public void init(Size fieldSize, Coords robotCoords) throws CustomException {
        robotCoords.validate(fieldSize);
        field = new Field(fieldSize);
        robot = new Robot(robotCoords, fieldSize);
        isInitialized = true;
    }
    /** Return initialized status */
    public boolean getIsInitialized() {
        return isInitialized;
    }
}
