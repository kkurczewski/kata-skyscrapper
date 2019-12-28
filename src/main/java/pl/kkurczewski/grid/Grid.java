package pl.kkurczewski.grid;

import pl.kkurczewski.grid.exception.core.ExcludeFailedException;
import pl.kkurczewski.grid.exception.core.SolveFailedException;

import java.util.Optional;

public class Grid {

    private final Cell[][] cells;
    private final int maxFloor;

    public Grid(Grid grid) {
        this.maxFloor = grid.maxFloor;
        this.cells = grid.cells;
    }

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

    public boolean solve(Coord coord, int givenFloor) {
        final int x = coord.x();
        final int y = coord.y();
        try {
            if (!cells[x][y].solve(givenFloor)) return false;

            for (int i = 0; i < maxFloor; i++) {
                if (i != x) exclude(new Coord(i, y), givenFloor);
                if (i != y) exclude(new Coord(x, i), givenFloor);
            }
        } catch (Exception ex) {
            throw new SolveFailedException(coord, givenFloor, ex);
        }
        return true;
    }

    public boolean exclude(Coord coord, int floorsNumber) {
        final int x = coord.x();
        final int y = coord.y();
        final Cell cell = cells[x][y];
        try {
            if (!cell.exclude(floorsNumber)) return false;

            for (int floor = 1; floor <= maxFloor; floor++) {
                for (int i = 0; i < maxFloor; i++) {
                    if (scanForSolution(x, i, floor)) solve(new Coord(x, i), floor);
                    if (scanForSolution(i, y, floor)) solve(new Coord(i, y), floor);
                }
            }
        } catch (Exception ex) {
            throw new ExcludeFailedException(coord, floorsNumber, ex);
        }
        return true;
    }

    public int[][] solution() {
        int[][] solution = new int[maxFloor][maxFloor];
        for (int i = 0; i < maxFloor; i++) {
            for (int j = 0; j < maxFloor; j++) {
                solution[i][j] = cells[i][j].solution().orElse(0);
            }
        }
        return solution;
    }

    public Optional<Integer> get(Coord coord) {
        return cells[coord.x()][coord.y()].solution();
    }

    public boolean hasCandidate(Coord coord, int candidate) {
        return cells[coord.x()][coord.y()].hasCandidate(candidate);
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
