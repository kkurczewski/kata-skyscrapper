package pl.kkurczewski.solver;

import pl.kkurczewski.grid.Grid;

import java.util.List;

public class Solver {

    private final Grid grid;
    private final int[][] clues;
    private final int maxFloor;

    public Solver(int[] clues) {
        this.maxFloor = (int) Math.sqrt(clues.length);
        this.grid = new Grid(maxFloor);
        this.clues = new int[maxFloor][maxFloor];
        for (int i = 0; i < maxFloor; i++) {
            System.arraycopy(clues, i * maxFloor, this.clues[i], 0, maxFloor);
        }
    }

    public void solve(List<Algorithm> algorithms) {
        algorithms.forEach(algorithm -> algorithm.solve(grid, clues));
    }

    public int[][] solution() {
        return grid.solution();
    }

    public void printGrid() {
        grid.print();
    }

    public void printClues() {
        System.out.print(" ");
        for (int i = 0; i < maxFloor; i++) {
            System.out.print(clues[0][i]);
        }
        System.out.println("");
        for (int i = 0; i < maxFloor; i++) {
            System.out.print(clues[3][maxFloor - i - 1]);
            System.out.print("    ");
            System.out.println(clues[1][i]);
        }
        System.out.print(" ");
        for (int i = 0; i < maxFloor; i++) {
            System.out.print(clues[2][maxFloor - i - 1]);
        }
        System.out.print("\n\n");
    }
}
