package pl.kkurczewski.algorithm;

import pl.kkurczewski.algorithm.util.RotatingCoord;
import pl.kkurczewski.grid.Coord;
import pl.kkurczewski.grid.Grid;
import pl.kkurczewski.solver.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class ExcludingPattern implements Algorithm {

    private final int expectedClue;
    private final List<Integer> expectedRow;
    private final List<Integer> solution;

    public ExcludingPattern(int expectedClue, List<Integer> expectedRow, List<Integer> solution) {
        this.expectedClue = expectedClue;
        this.expectedRow = expectedRow;
        this.solution = solution;
    }

    @Override
    public void solve(Grid grid, int[][] clues) {
        System.out.println(getClass());
        final int maxFloor = clues.length;
        RotatingCoord coord = new RotatingCoord(0, 0, maxFloor);
        for (int[] clueRow : clues) {
            for (int y = 0; y < maxFloor; y++) {
                final int clue = clueRow[y];

                if (clue == 0) continue;

                System.out.println(clue);
                List<Integer> solvedRow = trySolve(clue, grid, coord.offset(0, y));
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

    private List<Integer> trySolve(int givenClue, Grid grid, Coord coord) {
        return matches(givenClue, grid, coord) ? solution : new ArrayList<>();
    }

    private boolean matches(int givenClue, Grid grid, Coord coord) {
        if (expectedClue != givenClue) {
            return false;
        }
        for (int x = 0; x < expectedRow.size(); x++) {
            int expected = expectedRow.get(0);
            if (expected >= 0) continue;
            if (grid.hasCandidate(coord.offset(x, 0), Math.abs(expected))) return false;
        }
        return true;
    }
}
