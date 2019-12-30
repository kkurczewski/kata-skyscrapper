package pl.kkurczewski.algorithm;

import pl.kkurczewski.algorithm.util.CoordLens;
import pl.kkurczewski.grid.Grid;
import pl.kkurczewski.solver.Algorithm;

import java.util.List;

public class SolvingPattern implements Algorithm {

    private final List<PatternStep> steps;

    public SolvingPattern(List<PatternStep> steps) {
        this.steps = steps;
    }

    @Override
    public void solve(Grid grid, int[][] clues) {
        final int maxFloor = clues.length;
        CoordLens lens = new CoordLens(maxFloor - 1);
        for (int[] clueRow : clues) {
            for (int y = 0; y < maxFloor; y++) {
                final int clue = clueRow[y];

                if (clue == 0) continue;

                for (PatternStep step : steps) {
                    step.apply(grid, lens, clue, y);
                }
            }
            lens.rotateLeft();
        }
    }
}
