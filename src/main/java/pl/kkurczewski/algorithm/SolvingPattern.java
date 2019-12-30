package pl.kkurczewski.algorithm;

import pl.kkurczewski.algorithm.util.RotatingCoord;
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
        RotatingCoord coord = new RotatingCoord(0, 0, maxFloor);
        for (int[] clueRow : clues) {
            for (int y = 0; y < maxFloor; y++) {
                final int clue = clueRow[y];

                if (clue == 0) continue;

                for (PatternStep step : steps) {
                    step.apply(grid, coord, clue, y);
                }
            }
            coord = coord.rotateLeft();
        }
    }
}
