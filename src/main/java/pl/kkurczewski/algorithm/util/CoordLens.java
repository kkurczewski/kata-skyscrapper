package pl.kkurczewski.algorithm.util;

public class CoordLens {

    private static final int MAX_ROTATIONS = 4;

    private final int maxIndex;

    private int rotations;

    public CoordLens(int maxIndex) {
        this.maxIndex = maxIndex;
        this.rotations = 0;
    }

    public Coord coord(int x, int y) {
        int[] coord = new int[]{x, y};
        for (int i = 0; i < rotations; i++) {
            swap(coord);
            coord[1] = maxIndex - coord[1];
        }
        return new Coord(coord[0], coord[1]);
    }

    public void rotateLeft() {
        rotations = (rotations + 1) % MAX_ROTATIONS;
    }

    private void swap(int[] coord) {
        int tmp = coord[0];
        coord[0] = coord[1];
        coord[1] = tmp;
    }
}