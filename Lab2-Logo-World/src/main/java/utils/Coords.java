package utils;

public class Coords {
    public int x, y;
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
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
    public void validate(Size fieldSize) {
        this.x = this.x < 0
            ? fieldSize.w + this.x % fieldSize.w
            : this.x % fieldSize.w;
        this.y = this.y < 0
            ? fieldSize.h + this.y % fieldSize.h
            : this.y % fieldSize.h;
    }
}
