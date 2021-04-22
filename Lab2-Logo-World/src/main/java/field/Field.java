package field;

import utils.*;

import java.util.Arrays;

public class Field {

    private static final char EMPTY_CELL_CHAR = '.';
    private static final char FILLED_CELL_CHAR = '#';

    private final Size size;
    private final char[][] data;

    /**
     * Create Field instance
     *
     * @param size Field size
     * */
    public Field(Size size) throws CustomException {
        if (size.w <= 0 || size.h <= 0) {
            throw new CustomException("Negative com.field side size");
        }
        this.size = size;
        this.data = new char[size.w][size.h];
        for (char[] row : data) {
            Arrays.fill(row, EMPTY_CELL_CHAR);
        }
    }
    /**
     * Set field's cell with validated coords specified value
     *
     * @param coords   Cell coordinates
     * @param isFilled Cell type - filled / empty
     * */
    public void setCell(Coords coords, boolean isFilled) {
        coords.validate(size);
        data[coords.x][coords.y] = isFilled
            ? FILLED_CELL_CHAR
            : EMPTY_CELL_CHAR;
    }
    /** Return Field size */
    public Size getSize() {
        return size;
    }
    /** Return Field data */
    public char[][] getData() {
        return data;
    }
}
