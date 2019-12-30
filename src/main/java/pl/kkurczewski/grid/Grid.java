package pl.kkurczewski.grid;

import pl.kkurczewski.grid.exception.core.ExcludeFailedException;
import pl.kkurczewski.grid.exception.core.SolveFailedException;

import java.util.List;

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
                if (values[i][j] != 0) grid.solve(i, j, values[i][j]);
            }
        }
        return grid;
    }

    public boolean solve(int x, int y, int givenFloor) {
        try {
            if (!cells[x][y].solve(givenFloor)) return false;

            for (int i = 0; i < maxFloor; i++) {
                if (i != x) exclude(i, y, givenFloor);
                if (i != y) exclude(x, i, givenFloor);
            }
        } catch (Exception ex) {
            throw new SolveFailedException(x, y, givenFloor, ex);
        }
        return true;
    }

    public boolean exclude(int x, int y, int givenFloor) {
        try {
            List<Integer> result = cells[x][y].exclude(givenFloor);
            if (result.isEmpty()) return false;
            else if (result.size() == 1) solve(x, y, result.get(0));

            for (int floor = 1; floor <= maxFloor; floor++) {
                for (int i = 0; i < maxFloor; i++) {
                    if (scanForSolution(x, i, floor)) solve(x, i, floor);
                    if (scanForSolution(i, y, floor)) solve(i, y, floor);
                }
            }
        } catch (Exception ex) {
            throw new ExcludeFailedException(x, y, givenFloor, ex);
        }
        return true;
    }

    public int[][] solution() {
        int[][] solution = new int[maxFloor][maxFloor];
        for (int i = 0; i < maxFloor; i++) {
            for (int j = 0; j < maxFloor; j++) {
                solution[i][j] = get(i, j);
            }
        }
        return solution;
    }

    public int get(int x, int y) {
        return cells[x][y].solution();
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
