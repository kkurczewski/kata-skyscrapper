package pl.kkurczewski;

import pl.kkurczewski.algorithm.SolvingPattern;
import pl.kkurczewski.algorithm.SolvingPatternStep;
import pl.kkurczewski.grid.Grid;
import pl.kkurczewski.solver.Solver;

import java.util.List;

public class SkyScrapers {

    static int[][] solvePuzzle(int[] clues) {
        int maxFloor = (int) Math.sqrt(clues.length);
        Solver solver = new Solver(new Grid(maxFloor), clues);

        return solver.solve(List.of(
                // core
                new SolvingPattern(List.of(
                        new SolvingPatternStep(1, List.of(0, 0, 0, 0), List.of(4, 0, 0, 0)),
                        new SolvingPatternStep(3, List.of(0, 0, 0, 0), List.of(-4, -4, 0, 0)),
                        new SolvingPatternStep(2, List.of(0, 0, 0, 0), List.of(-4, -3, 0, 0)),
                        new SolvingPatternStep(3, List.of(0, 0, 0, 0), List.of(-3, 0, 0, 0))
                )),
                // single with clue 2
                new SolvingPattern(List.of(
                        new SolvingPatternStep(2, List.of(0, 0, 0, 4), List.of(3, 0, 0, 0)),
                        new SolvingPatternStep(2, List.of(0, 0, 4, 0), List.of(-1, 0, 0, 0)),
                        new SolvingPatternStep(2, List.of(0, 0, 3, 0), List.of(0, 4, 0, 0)),
                        new SolvingPatternStep(2, List.of(0, 0, 2, 0), List.of(0, 4, 0, 0)),
                        new SolvingPatternStep(2, List.of(0, 2, 0, 0), List.of(3, 0, 0, 0)),
                        new SolvingPatternStep(2, List.of(2, 0, 0, 0), List.of(0, -3, 0, 0)),
                        new SolvingPatternStep(2, List.of(1, 0, 0, 0), List.of(0, 4, 0, 0))
                )),
                // grande finale
                new SolvingPattern(List.of(
                        new SolvingPatternStep(3, List.of(0, 0, 0, 3), List.of(1, 2, 4, 0)),
                        new SolvingPatternStep(3, List.of(0, 0, 3, 0), List.of(2, 1, 0, 4)),
                        new SolvingPatternStep(3, List.of(0, 0, 0, 1), List.of(2, 3, 4, 0)),
                        new SolvingPatternStep(3, List.of(0, 0, 1, 0), List.of(2, 3, 0, 4)),
                        new SolvingPatternStep(3, List.of(0, 0, 0, 2), List.of(1, 3, 4, 0)),
                        new SolvingPatternStep(3, List.of(0, 0, 2, 0), List.of(1, 3, 0, 4)),
                        new SolvingPatternStep(3, List.of(0, 2, 0, 0), List.of(1, 0, 4, 3))
                ))
        ));
    }
}
