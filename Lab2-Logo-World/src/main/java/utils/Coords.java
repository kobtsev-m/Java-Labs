package utils;

public class Coords {
    public int x, y;
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Coords add(Coords other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }
    public Coords mul(int n) {
        this.x *= n;
        this.y *= n;
        return this;
    }
}
