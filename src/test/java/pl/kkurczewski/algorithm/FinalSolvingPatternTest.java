package pl.kkurczewski.algorithm;

import org.junit.Test;
import pl.kkurczewski.solver.Algorithm;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalSolvingPatternTest extends AlgorithmSmokeTest {

    @Override
    protected Algorithm smokeTestSupplier() {
        return (grid, clues) -> {
            new SolvingPattern(2, List.of(0, 0, 0, 4), List.of(3, 0, 0, 4)).solve(grid, clues);
            new SolvingPattern(2, List.of(0, 0, 4, 0), List.of(-1, 0, 4, 0)).solve(grid, clues);
            new SolvingPattern(2, List.of(0, 4, 0, 0), List.of(0, 4, 0, 0)).solve(grid, clues);

            new SolvingPattern(2, List.of(0, 0, 4, 3), List.of(2, 1, 4, 3)).solve(grid, clues);
            new SolvingPattern(2, List.of(0, 1, 4, 3), List.of(2, 1, 4, 3)).solve(grid, clues);
            new SolvingPattern(2, List.of(2, 0, 4, 3), List.of(2, 1, 4, 3)).solve(grid, clues);
        };
    }
    
    @Test
    public void insufficientMatch() {
        SolvingPattern solvingPattern = new SolvingPattern(2, List.of(0, 0, 4, 3), List.of(2, 1, 4, 3));

        assertThat(solvingPattern.trySolve(2, List.of(0, 0, 0, 0))).isEmpty();
        assertThat(solvingPattern.trySolve(2, List.of(0, 0, 4, 0))).isEmpty();
        assertThat(solvingPattern.trySolve(2, List.of(0, 0, 0, 3))).isEmpty();
        assertThat(solvingPattern.trySolve(0, List.of(0, 0, 4, 3))).isEmpty();
    }

    @Test
    public void failedMatch() {
        SolvingPattern solvingPattern = new SolvingPattern(2, List.of(0, 0, 4, 3), List.of(2, 1, 4, 3));

        assertThat(solvingPattern.trySolve(2, List.of(0, 3, 4, 0))).isEmpty();
        assertThat(solvingPattern.trySolve(2, List.of(0, 0, 2, 1))).isEmpty();

        assertThat(solvingPattern.trySolve(3, List.of(0, 0, 0, 0))).isEmpty();
        assertThat(solvingPattern.trySolve(3, List.of(0, 0, 4, 3))).isEmpty();

        assertThat(solvingPattern.trySolve(2, List.of(0, 0, -4, 3))).isEmpty();
        assertThat(solvingPattern.trySolve(2, List.of(0, 0, 4, -3))).isEmpty();
        assertThat(solvingPattern.trySolve(2, List.of(0, 0, -4, -3))).isEmpty();
    }

    @Test
    public void match() {
        SolvingPattern solvingPattern = new SolvingPattern(2, List.of(0, 0, 4, 3), List.of(2, 1, 4, 3));

        assertThat(solvingPattern.trySolve(2, List.of(0, 0, 4, 3))).containsOnly(2, 1, 4, 3);
        assertThat(solvingPattern.trySolve(2, List.of(0, 1, 4, 3))).containsOnly(2, 1, 4, 3);
        assertThat(solvingPattern.trySolve(2, List.of(2, 0, 4, 3))).containsOnly(2, 1, 4, 3);
    }

    @Test
    public void exclusion() {
        SolvingPattern solvingPattern = new SolvingPattern(2, List.of(0, 0, 4, 0), List.of(-1, 0, 0, 0));

        assertThat(solvingPattern.trySolve(2, List.of(0, 0, 4, 0))).containsOnly(-1, 0, 0, 0);
    }
}