package pl.kkurczewski.grid;

import static java.lang.String.format;

public class Coord {

    private final int x;
    private final int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Coord offset(int dx, int dy) {
        return new Coord(x + dx, y + dy);
    }

    @Override
    public String toString() {
        return format("(%d,%d)", x(), y());
    }
}