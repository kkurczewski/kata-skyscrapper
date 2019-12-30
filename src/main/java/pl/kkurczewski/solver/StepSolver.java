package pl.kkurczewski.solver;

import java.util.ArrayList;
import java.util.List;

public class StepSolver extends Solver {

    private final List<String> gridSteps = new ArrayList<>();

    public StepSolver(Solver solver) {
        super(solver);
    }

    public int[][] solve(List<Algorithm> algorithms) {
        algorithms.forEach(algorithm -> {
            algorithm.solve(grid, clues);
            gridSteps.add(this.toString());
        });

        return grid.solution();
    }

    public List<String> steps() {
        return gridSteps;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // print top clues
        builder.append(" |");
        for (int i = 0; i < maxFloor; i++) {
            builder.append(clues[0][i]);
        }
        builder.append("|").append(System.lineSeparator())
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
        builder.append("|");

        return builder.toString();
    }
}
