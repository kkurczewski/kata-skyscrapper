package pl.kkurczewski.algorithm.util;

public class Coord {

    private final int x;
    private final int y;

    Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    int[] toArray() {
        return new int[]{x, y};
    }
}