package pl.kkurczewski.algorithm;

import pl.kkurczewski.algorithm.util.Coord;
import pl.kkurczewski.grid.Grid;

import java.util.ArrayList;
import java.util.List;

public class SolvingPatternStep implements PatternStep {

    private final int expectedClue;
    private final List<Integer> expectedRow;
    private final List<Integer> solution;
    private int maxFloor;

    public SolvingPatternStep(int expectedClue, List<Integer> expectedRow, List<Integer> solution) {
        if (expectedRow.size() != solution.size()) {
            throw new IllegalArgumentException("Expected row and output solution should have same length");
        }
        this.expectedClue = expectedClue;
        this.expectedRow = expectedRow;
        this.solution = solution;
        this.maxFloor = solution.size();
    }

    @Override
    public void apply(Grid grid, Coord coord, int clue, int y) {
        List<Integer> actualRow = new ArrayList<>();
        for (int x = 0; x < maxFloor; x++) {
            actualRow.add(grid.get(coord.offset(x, y).x(), coord.offset(x, y).y()));
        }

        List<Integer> solvedRow = matches(clue, actualRow) ? solution : new ArrayList<>();
        for (int x = 0; x < solvedRow.size(); x++) {
            final int solution = solvedRow.get(x);
            if (solution > 0) grid.solve(coord.offset(x, y).x(), coord.offset(x,y).y(), solution);
            else if (solution < 0) grid.exclude(coord.offset(x, y).x(), coord.offset(x, y).y(), Math.abs(solution));
        }
    }

    private boolean matches(int givenClue, List<Integer> givenRow) {
        if (expectedClue != givenClue || expectedRow.size() != givenRow.size()) {
            return false;
        }
        for (int i = 0; i < expectedRow.size(); i++) {
            final int expected = expectedRow.get(i);
            if (expected > 0 && expected != givenRow.get(i)) return false;
            if (expected < 0 && Math.abs(expected) == givenRow.get(i)) return false;
        }
        return true;
    }
}
