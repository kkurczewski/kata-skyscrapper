package pl.kkurczewski.grid;

import java.util.Optional;

public class Grid {

    private final Cell[][] cells;
    private final int maxFloor;

    public Grid(int maxFloor) {
        this.maxFloor = maxFloor;
        this.cells = new Cell[maxFloor][maxFloor];
        for (int i = 0; i < maxFloor; i++) {
            for (int j = 0; j < maxFloor; j++) {
                cells[i][j] = new Cell(4);
            }
        }
    }

    public static Grid from(int[][] values) {
        Grid grid = new Grid(values.length);
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                if (values[i][j] != 0) grid.solve(new Coord(i, j), values[i][j]);
            }
        }
        return grid;
    }

    public void solve(Coord coord, int floorsNumber) {
        final int x = coord.x();
        final int y = coord.y();
        try {
            if (!cells[x][y].solve(floorsNumber)) return;

            System.out.println("(" + x + ", " + y + ") == " + floorsNumber);

            for (int i = 0; i < maxFloor; i++) {
                if (i != x) {
                    cells[i][y].exclude(floorsNumber);
                }
                if (i != y) {
                    cells[x][i].exclude(floorsNumber);
                }
            }
            for (int i = 0; i < maxFloor; i++) {
                if (i != x) scanAfterExclusion(x, y);
                if (i != y) scanAfterExclusion(x, i);
            }
        } catch (IllegalStateException ex) {
            throw new IllegalStateException("Failed to set solution for cell: [" + x + ", " + y + "]", ex);
        }
    }

    public void exclude(Coord coord, int floorsNumber) {
        final int x = coord.x();
        final int y = coord.y();
        final Cell cell = cells[x][y];
        try {
            if (!cell.exclude(floorsNumber)) return;
            System.out.println("(" + x + ", " + y + ") != " + floorsNumber);

            scanAfterExclusion(x, y);
        } catch (IllegalStateException ex) {
            throw new IllegalStateException("Exclusion failed for cell: [" + x + ", " + y + "]", ex);
        }
    }

    public int[][] solution() {
        int[][] solution = new int[maxFloor][maxFloor];
        for (int i = 0; i < maxFloor; i++) {
            for (int j = 0; j < maxFloor; j++) {
                solution[i][j] = cells[i][j].solution().orElseThrow();
            }
        }
        return solution;
    }

    public Optional<Integer> solution(Coord coord) {
        return cells[coord.x()][coord.y()].solution();
    }

    public boolean isMarkedAs(Coord coord, int expected) {
        return cells[coord.x()][coord.y()].solution().filter(solution -> solution == expected).isPresent();
    }

    public boolean hasCandidate(Coord coord, int candidate) {
        return cells[coord.x()][coord.y()].hasCandidate(candidate);
    }

    public void print() {
        for (Cell[] row : cells) {
            for (Cell column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
        System.out.print("\n\n");
    }

    private void scanAfterExclusion(int x, int y) {
        for (int floor = 1; floor <= maxFloor; floor++) {
            for (int i = 0; i < maxFloor; i++) {
                if (scanForSolution(x, i, floor)) solve(new Coord(x, i), floor);
                if (scanForSolution(i, y, floor)) solve(new Coord(i, y), floor);
            }
        }
    }

    private boolean scanForSolution(int x, int y, int floorsNumber) {
        if (!cells[x][y].hasCandidate(floorsNumber)) return false;
        int rowCollisions = 0;
        int columnCollisions = 0;
        for (int i = 0; i < maxFloor; i++) {
            if (i != x && (cells[i][y].hasSolution(floorsNumber) || cells[i][y].hasCandidate(floorsNumber))) {
                rowCollisions++;
            }
            if (i != y && (cells[x][i].hasSolution(floorsNumber) || cells[x][i].hasCandidate(floorsNumber))) {
                columnCollisions++;
            }

            if (rowCollisions > 0 && columnCollisions > 0) return false;
        }
        return true;
    }
}
