package pl.kkurczewski.algorithm;

import org.junit.Test;
import pl.kkurczewski.grid.FailFastGrid;
import pl.kkurczewski.solver.Algorithm;

public abstract class AlgorithmSmokeTest {

    protected final int[][] clues = {
            {2, 2, 1, 3},
            {2, 2, 3, 1},
            {1, 2, 2, 3},
            {3, 2, 1, 3}
    };
    protected final int[][] solution = {
            {1, 3, 4, 2},
            {4, 2, 1, 3},
            {3, 4, 2, 1},
            {2, 1, 3, 4}
    };

    @Test
    public void shouldNotThrow() {
        smokeTestSupplier().solve(new FailFastGrid(solution), clues);
    }

    protected abstract Algorithm smokeTestSupplier();
}
