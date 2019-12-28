package pl.kkurczewski;

import pl.kkurczewski.algorithm.SolvingPattern;
import pl.kkurczewski.grid.Grid;
import pl.kkurczewski.grid.LoggingGridMarker;
import pl.kkurczewski.solver.Solver;

import java.util.ArrayList;
import java.util.List;

import static pl.kkurczewski.algorithm.NamedAlgorithm.named;

public class SkyScrapers {

    static int[][] solvePuzzle(int[] clues) {
        int maxFloor = (int) Math.sqrt(clues.length);
        List<String> log = new ArrayList<>();
        LoggingGridMarker loggingGrid = new LoggingGridMarker(new Grid(maxFloor), log::add);
        Solver solver = new Solver(loggingGrid, clues);

        int[][] solution = solver.solve(List.of(
                // core
                named("1", new SolvingPattern(1, List.of(0, 0, 0, 0), List.of(4, 0, 0, 0))),
                named("2", new SolvingPattern(3, List.of(0, 0, 0, 0), List.of(-4, -4, 0, 0))),
                named("3", new SolvingPattern(2, List.of(0, 0, 0, 0), List.of(-4, -3, 0, 0))),
                named("4", new SolvingPattern(3, List.of(0, 0, 0, 0), List.of(-3, 0, 0, 0))),
                // single with clue 2
                named("5", new SolvingPattern(2, List.of(0, 0, 0, 4), List.of(3, 0, 0, 0))),
                named("6", new SolvingPattern(2, List.of(0, 0, 4, 0), List.of(-1, 0, 0, 0))),
                named("7", new SolvingPattern(2, List.of(0, 0, 3, 0), List.of(0, 4, 0, 0))),
                named("8", new SolvingPattern(2, List.of(0, 0, 2, 0), List.of(0, 4, 0, 0))),
                named("9", new SolvingPattern(2, List.of(0, 2, 0, 0), List.of(3, 0, 0, 0))),
                named("10", new SolvingPattern(2, List.of(2, 0, 0, 0), List.of(0, -3, 0, 0))),
                named("11", new SolvingPattern(2, List.of(1, 0, 0, 0), List.of(0, 4, 0, 0))),
                // grande finale
                named("12", new SolvingPattern(3, List.of(0, 0, 0, 3), List.of(1, 2, 4, 0))),
                named("13", new SolvingPattern(3, List.of(0, 0, 3, 0), List.of(2, 1, 0, 4))),
                named("14", new SolvingPattern(3, List.of(0, 0, 0, 1), List.of(2, 3, 4, 0))),
                named("15", new SolvingPattern(3, List.of(0, 0, 1, 0), List.of(2, 3, 0, 4))),
                named("16", new SolvingPattern(3, List.of(0, 0, 0, 2), List.of(1, 3, 4, 0))),
                named("17", new SolvingPattern(3, List.of(0, 0, 2, 0), List.of(1, 3, 0, 4))),
                named("18", new SolvingPattern(3, List.of(0, 2, 0, 0), List.of(1, 0, 4, 3)))
        ));

        System.out.println(solver.toString());

        log.forEach(System.out::println);

        return solution;
    }
}
