package pl.kkurczewski;

import pl.kkurczewski.algorithm.SolvingPattern;
import pl.kkurczewski.grid.Grid;
import pl.kkurczewski.solver.Solver;

import static java.util.List.of;
import static pl.kkurczewski.algorithm.SolvingPatternStep.step;

public class SkyScrapers {

    static int[][] solvePuzzle(int[] clues) {
        int maxFloor = (int) Math.sqrt(clues.length);
        Solver solver = new Solver(new Grid(maxFloor), clues);

        return solver.solve(of(
                // core
                new SolvingPattern(of(
                        step(1, of(0, 0, 0, 0), of(4, 0, 0, 0)),
                        step(3, of(0, 0, 0, 0), of(-4, -4, 0, 0)),
                        step(2, of(0, 0, 0, 0), of(-4, -3, 0, 0)),
                        step(3, of(0, 0, 0, 0), of(-3, 0, 0, 0))
                )),
                // single with clue 2
                new SolvingPattern(of(
                        step(2, of(0, 0, 0, 4), of(3, 0, 0, 0)),
                        step(2, of(0, 0, 4, 0), of(-1, 0, 0, 0)),
                        step(2, of(0, 0, 3, 0), of(0, 4, 0, 0)),
                        step(2, of(0, 0, 2, 0), of(0, 4, 0, 0)),
                        step(2, of(0, 2, 0, 0), of(3, 0, 0, 0)),
                        step(2, of(2, 0, 0, 0), of(0, -3, 0, 0)),
                        step(2, of(1, 0, 0, 0), of(0, 4, 0, 0))
                )),
                // grande finale
                new SolvingPattern(of(
                        step(3, of(0, 0, 0, 3), of(1, 2, 4, 0)),
                        step(3, of(0, 0, 3, 0), of(2, 1, 0, 4)),
                        step(3, of(0, 0, 0, 1), of(2, 3, 4, 0)),
                        step(3, of(0, 0, 1, 0), of(2, 3, 0, 4)),
                        step(3, of(0, 0, 0, 2), of(1, 3, 4, 0)),
                        step(3, of(0, 0, 2, 0), of(1, 3, 0, 4)),
                        step(3, of(0, 2, 0, 0), of(1, 0, 4, 3))
                ))
        ));
    }
}
