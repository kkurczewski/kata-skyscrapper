package pl.kkurczewski.solver;

import pl.kkurczewski.grid.Grid;

import java.util.List;

public class Solver {

    private final Grid grid;
    private final int[][] clues;
    private final int maxFloor;

    public Solver(Grid grid, int[] clues) {
        this.maxFloor = (int) Math.sqrt(clues.length);
        this.grid = grid;
        this.clues = new int[maxFloor][maxFloor];
        for (int i = 0; i < maxFloor; i++) {
            System.arraycopy(clues, i * maxFloor, this.clues[i], 0, maxFloor);
        }
    }

    public int[][] solve(List<Algorithm> algorithms) {
        algorithms.forEach(algorithm -> {
            algorithm.solve(grid, clues);
            System.out.println(this.toString());
        });

        return grid.solution();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // print top clues
        builder.append(" |");
        for (int i = 0; i < maxFloor; i++) {
            builder.append(clues[0][i]);
        }
        builder.append("| ").append(System.lineSeparator())
                .append("-+----+-").append(System.lineSeparator());

        // print solution and sides clues
        final int[][] solution = grid.solution();
        for (int i = 0; i < maxFloor; i++) {
            builder.append(clues[3][maxFloor - i - 1]).append("|");
            for (int j = 0; j < maxFloor; j++) {
                final int value = solution[i][j];
                builder.append(value == 0 ? "?" : value);
            }
            builder.append("|").append(clues[1][i]);
            builder.append(System.lineSeparator());
        }

        // print bottom clues
        builder.append("-+----+-").append(System.lineSeparator()).append(" |");
        for (int i = 0; i < maxFloor; i++) {
            builder.append(clues[2][maxFloor - i - 1]);
        }
        builder.append("| ").append(System.lineSeparator());

        return builder.toString();
    }
}
