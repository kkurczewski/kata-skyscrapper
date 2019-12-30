package pl.kkurczewski.solver;

import pl.kkurczewski.grid.Grid;

public class Solver {

    protected final Grid grid;
    protected final int[][] clues;
    protected final int maxFloor;

    public Solver(Grid grid, int[] clues) {
        this.maxFloor = (int) Math.sqrt(clues.length);
        this.grid = grid;
        this.clues = new int[maxFloor][maxFloor];
        for (int i = 0; i < maxFloor; i++) {
            System.arraycopy(clues, i * maxFloor, this.clues[i], 0, maxFloor);
        }
    }

    public Solver(Solver solver) {
        this.maxFloor = solver.maxFloor;
        this.grid = solver.grid;
        this.clues = solver.clues;
    }

    public int[][] solve(Algorithm algorithm) {
        algorithm.solve(grid, clues);

        return grid.solution();
    }
}
