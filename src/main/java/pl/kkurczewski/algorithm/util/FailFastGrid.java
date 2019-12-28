package pl.kkurczewski.algorithm.util;

import pl.kkurczewski.grid.Coord;
import pl.kkurczewski.grid.Grid;

import static java.lang.String.format;

public class FailFastGrid extends Grid {

    private final int[][] solution;

    public FailFastGrid(int[][] solution) {
        super(solution.length);
        this.solution = solution;
    }

    @Override
    public void solve(Coord coord, int floorsNumber) {
        int correctAnswer = solution[coord.x()][coord.y()];
        if (correctAnswer != floorsNumber) {
            super.print();
            throw new IllegalArgumentException(format(
                    "Bad solution provided, correct answer is: %d but instead got: %d for: %s",
                    correctAnswer, floorsNumber, coord));
        }
        super.solve(coord, floorsNumber);
    }

    @Override
    public void exclude(Coord coord, int floorsNumber) {
        if (solution[coord.x()][coord.y()] == floorsNumber) {
            super.print();
            throw new IllegalArgumentException(format("Bad exclusion: %d, is correct answer for: %s", // TODO review
                    floorsNumber, coord));
        }
        super.exclude(coord, floorsNumber);
    }
}
