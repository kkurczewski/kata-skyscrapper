package pl.kkurczewski.grid;

import pl.kkurczewski.grid.exception.failfast.InvalidExclusionException;
import pl.kkurczewski.grid.exception.failfast.InvalidSolutionException;

public class FailFastGrid extends Grid {

    private final int[][] solution;

    public FailFastGrid(int[][] solution) {
        super(solution.length);
        this.solution = solution;
    }

    @Override
    public boolean solve( int x, int y, int givenFloor) {
        int correctAnswer = solution[x][y];
        if (correctAnswer != givenFloor) {
            throw new InvalidSolutionException(x, y, correctAnswer, givenFloor);
        }
        return super.solve(x, y, givenFloor);
    }

    @Override
    public boolean exclude( int x, int y, int givenFloor) {
        if (solution[x][y] == givenFloor) {
            throw new InvalidExclusionException(x, y, givenFloor);
        }
        return super.exclude(x, y, givenFloor);
    }
}
