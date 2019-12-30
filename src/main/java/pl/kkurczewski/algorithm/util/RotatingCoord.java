package pl.kkurczewski.algorithm.util;

public class RotatingCoord extends Coord {

    private static final int MAX_ROTATIONS = 4;

    private final int maxFloor;
    private final int rotations;

    public RotatingCoord(int x, int y, int maxFloor) {
        this(x, y, maxFloor, 0);
    }

    private RotatingCoord(int x, int y, int maxFloor, int rotations) {
        super(x, y);
        this.maxFloor = maxFloor;
        this.rotations = rotations % MAX_ROTATIONS;
    }

    private RotatingCoord(Coord coord, int maxFloor, int rotations) {
        this(coord.x(), coord.y(), maxFloor, rotations);
    }

    @Override
    public int x() {
        return rotate().x();
    }

    @Override
    public int y() {
        return rotate().y();
    }

    @Override
    public RotatingCoord offset(int dx, int dy) {
        return new RotatingCoord(super.offset(dx, dy), maxFloor, rotations);
    }

    public RotatingCoord rotateLeft() {
        return new RotatingCoord(super.x(), super.y(), maxFloor, rotations + 1);
    }

    private Coord rotate() {
        Coord coord = new Coord(super.x(), super.y());
        for (int i = 0; i < rotations; i++) {
            coord = new Coord(coord.y(), maxFloor - coord.x() - 1);
        }
        return coord;
    }
}