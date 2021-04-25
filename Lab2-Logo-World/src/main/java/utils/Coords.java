package utils;

public class Coords {
    public int x, y;
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Coords other = (Coords) obj;
        return this.x == other.x && this.y == other.y;
    }
    public Coords add(Coords other) {
        return new Coords(
            this.x + other.x,
            this.y + other.y
        );
    }
    public Coords mul(int n) {
        return new Coords(
            this.x * n,
            this.y * n
        );
    }
    public void validate(Size fieldSize) throws CustomException {
        fieldSize.validate();
        this.x = this.x < 0
            ? fieldSize.w + this.x % fieldSize.w
            : this.x % fieldSize.w;
        this.y = this.y < 0
            ? fieldSize.h + this.y % fieldSize.h
            : this.y % fieldSize.h;
    }
}
