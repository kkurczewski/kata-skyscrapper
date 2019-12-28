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
    public boolean solve(Coord coord, int givenFloor) {
        int correctAnswer = solution[coord.x()][coord.y()];
        if (correctAnswer != givenFloor) {
            throw new InvalidSolutionException(correctAnswer, givenFloor, coord);
        }
        return super.solve(coord, givenFloor);
    }

    @Override
    public boolean exclude(Coord coord, int givenFloor) {
        if (solution[coord.x()][coord.y()] == givenFloor) {
            throw new InvalidExclusionException(givenFloor, coord);
        }
        return super.exclude(coord, givenFloor);
    }
}
