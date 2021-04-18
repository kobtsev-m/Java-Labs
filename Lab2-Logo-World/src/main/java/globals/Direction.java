package globals;

import utils.Coords;

import java.util.HashMap;
import java.util.Map;

public class Direction {

    private final Map<String, Coords> directionsMap =
        new HashMap<String, Coords>() {{
            put("u", new Coords(0, -1));
            put("d", new Coords(0, 1));
            put("r", new Coords(1, 0));
            put("l", new Coords(-1, 0));
        }};

    private boolean isDirectionValid(String dir) {
        return directionsMap.containsKey(dir.toLowerCase());
    }
    public Coords getCoords(String dir) {
        if (!isDirectionValid(dir)) {
            return new Coords(0, 0);
        }
        return directionsMap.get(dir.toLowerCase());
    }
}
