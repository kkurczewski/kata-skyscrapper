package pl.kkurczewski;

import org.junit.jupiter.api.Test;
import pl.kkurczewski.grid.Grid;
import pl.kkurczewski.solver.Solver;

public class SmokeTestTemplate {

    private final int[][] clues = new int[][]{
            {2, 2, 1, 3, 2, 2, 3, 1, 1, 2, 2, 3, 3, 2, 1, 3},
            {0, 0, 1, 2, 0, 2, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0},
            {1, 2, 4, 2, 2, 1, 3, 2, 3, 1, 2, 3, 3, 2, 2, 1}
    };

    @Test
    public void shouldNotThrow() {
        for (int[] clue : clues) {
            Solver solver = new Solver(new Grid(4), clue);
            solver.solve(new FinalAlgorithm());
        }
    }
}
