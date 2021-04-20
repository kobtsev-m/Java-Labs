package field;

import utils.*;

import java.util.Arrays;

public class Field {

    private static final char EMPTY_CELL_CHAR = '.';
    private static final char FILLED_CELL_CHAR = '#';

    private final Size size;
    private final char[][] data;

    public Field(Size size) throws CustomException {
        if (size.w < 0 || size.h < 0) {
            throw new CustomException("Negative com.field side size");
        }
        this.size = size;
        this.data = new char[size.w][size.h];
        for (char[] row : data) {
            Arrays.fill(row, EMPTY_CELL_CHAR);
        }
    }
    public void setCell(Coords coords, boolean isFilled) {
        coords.validate(size);
        data[coords.x][coords.y] = isFilled
            ? FILLED_CELL_CHAR
            : EMPTY_CELL_CHAR;
    }
    public char getCell(Coords coords) {
        coords.validate(size);
        return data[coords.x][coords.y];
    }
    public Size getSize() {
        return size;
    }
    public char[][] getData() {
        return data;
    }
}
