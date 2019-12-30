package pl.kkurczewski.algorithm;

import pl.kkurczewski.solver.Algorithm;

import java.util.List;

import static pl.kkurczewski.algorithm.NamedAlgorithm.named;

public class SolvingPatternSmokeTest extends SmokeTestTemplate {

    @Override
    protected Algorithm smokeTestSupplier() {
        return (grid, clues) -> {
            // core
            named("1", new SolvingPattern(1, List.of(0, 0, 0, 0), List.of(4, 0, 0, 0))).solve(grid, clues);
            named("2", new SolvingPattern(3, List.of(0, 0, 0, 0), List.of(-4, -4, 0, 0))).solve(grid, clues);
            named("3", new SolvingPattern(2, List.of(0, 0, 0, 0), List.of(-4, -3, 0, 0))).solve(grid, clues);
            named("4", new SolvingPattern(3, List.of(0, 0, 0, 0), List.of(-3, 0, 0, 0))).solve(grid, clues);
            // single with clue 2
            named("5", new SolvingPattern(2, List.of(0, 0, 0, 4), List.of(3, 0, 0, 0))).solve(grid, clues);
            named("6", new SolvingPattern(2, List.of(0, 0, 4, 0), List.of(-1, 0, 0, 0))).solve(grid, clues);
            named("7", new SolvingPattern(2, List.of(0, 0, 3, 0), List.of(0, 4, 0, 0))).solve(grid, clues);
            named("8", new SolvingPattern(2, List.of(0, 0, 2, 0), List.of(0, 4, 0, 0))).solve(grid, clues);
            named("9", new SolvingPattern(2, List.of(0, 2, 0, 0), List.of(3, 0, 0, 0))).solve(grid, clues);
            named("10", new SolvingPattern(2, List.of(2, 0, 0, 0), List.of(0, 4, 0, 0))).solve(grid, clues);
            named("11", new SolvingPattern(2, List.of(1, 0, 0, 0), List.of(0, 4, 0, 0))).solve(grid, clues);
            // grande finale
            named("12", new SolvingPattern(3, List.of(0, 0, 0, 3), List.of(1, 2, 4, 0))).solve(grid, clues);
            named("13", new SolvingPattern(3, List.of(0, 0, 3, 0), List.of(2, 1, 0, 4))).solve(grid, clues);
            named("14", new SolvingPattern(3, List.of(0, 0, 0, 1), List.of(2, 3, 4, 0))).solve(grid, clues);
            named("15", new SolvingPattern(3, List.of(0, 0, 1, 0), List.of(2, 3, 0, 4))).solve(grid, clues);
            named("16", new SolvingPattern(3, List.of(0, 0, 0, 2), List.of(1, 3, 4, 0))).solve(grid, clues);
            named("17", new SolvingPattern(3, List.of(0, 0, 2, 0), List.of(1, 3, 0, 4))).solve(grid, clues);
            named("18", new SolvingPattern(3, List.of(0, 2, 0, 0), List.of(1, 0, 4, 3))).solve(grid, clues);
        };
    }

}