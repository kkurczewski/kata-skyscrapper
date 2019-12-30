package pl.kkurczewski.solver;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.kkurczewski.algorithm.SolvingPattern;
import pl.kkurczewski.algorithm.SolvingPatternStep;
import pl.kkurczewski.grid.Grid;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;

public class StepSolverTest {

    private final int[] clues = {
            2, 2, 1, 3,
            2, 2, 3, 1,
            1, 2, 2, 3,
            3, 2, 1, 3
    };

    // FIXME
    @Disabled
    @Test
    public void shouldLogGridStateAfterEachAlgorithm() {
        StepSolver solver = new StepSolver(new Solver(new Grid(4), clues));
        solver.solve(List.of(
                new SolvingPattern(List.of(
                        new SolvingPatternStep(1, List.of(0, 0, 0, 0), List.of(4, 0, 0, 0)),
                        new SolvingPatternStep(2, List.of(0, 0, 0, 4), List.of(3, 0, 0, 0))
                ))));

        assertThat(solver.steps()).containsOnly(
                getResourceAsString("step-solver-1.txt"),
                getResourceAsString("step-solver-2.txt")
        );
    }

    private String getResourceAsString(String resource) {
        InputStream in = requireNonNull(this.getClass().getClassLoader().getResourceAsStream(resource));
        return new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.joining(System.lineSeparator()));
    }
}