package pl.kkurczewski.algorithm;

import pl.kkurczewski.algorithm.util.RotatingCoord;
import pl.kkurczewski.grid.Grid;
import pl.kkurczewski.solver.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class SolvingPattern implements Algorithm {

    private final int expectedClue;
    private final List<Integer> expectedRow;
    private final List<Integer> solution;

    public SolvingPattern(int expectedClue, List<Integer> expectedRow, List<Integer> solution) {
        this.expectedClue = expectedClue;
        this.expectedRow = expectedRow;
        this.solution = solution;
    }

    @Override
    public void solve(Grid grid, int[][] clues) {
        final int maxFloor = clues.length;
        RotatingCoord coord = new RotatingCoord(0, 0, maxFloor);
        for (int[] clueRow : clues) {
            for (int y = 0; y < maxFloor; y++) {
                final int clue = clueRow[y];

                if (clue == 0) continue;

                List<Integer> actualRow = new ArrayList<>();
                for (int x = 0; x < maxFloor; x++) {
                    actualRow.add(grid.get(coord.offset(x, y)));
                }

                List<Integer> solvedRow = trySolve(clue, actualRow);
                for (int x = 0; x < solvedRow.size(); x++) {
                    final int solution = solvedRow.get(x);
                    if (solution > 0) grid.solve(coord.offset(x, y), solution);
                    else if (solution < 0) grid.exclude(coord.offset(x, y), Math.abs(solution));
                }
            }
            System.out.println();
            coord = coord.rotateLeft();
        }
    }

    List<Integer> trySolve(int givenClue, List<Integer> givenRow) { // TODO hide?
        return matches(givenClue, givenRow) ? solution : new ArrayList<>();
    }

    private boolean matches(int givenClue, List<Integer> givenRow) {
        if (expectedClue != givenClue || expectedRow.size() != givenRow.size()) {
            return false;
        }
        for (int i = 0; i < expectedRow.size(); i++) {
            final int expected = expectedRow.get(i);
            if (expected == 0) continue;
            if (expected > 0 && expected != givenRow.get(i)) return false;
            if (expected < 0 && Math.abs(expected) == givenRow.get(i)) return false;
        }
        return true;
    }
}
