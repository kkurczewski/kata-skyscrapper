package pl.kkurczewski.algorithm;

import pl.kkurczewski.algorithm.util.RotatingCoord;
import pl.kkurczewski.grid.Grid;
import pl.kkurczewski.solver.Algorithm;

public class SingleAlgorithm implements Algorithm {

    @Override
    public void solve(Grid grid, int[][] clues) {
        System.out.println(getClass());
        final int maxFloor = clues.length;
        RotatingCoord coord = new RotatingCoord(0, 0, maxFloor);
        for (int[] clueRow : clues) {
            for (int y = 0; y < maxFloor; y++) {
                final int clue = clueRow[y];

                if (clue == 0) continue;

                // second highest
                if (clue == 2 && grid.solution(coord.offset(maxFloor - 1, y))
                        .filter(it -> it == maxFloor)
                        .isPresent()) {
                    grid.solve(coord.offset(0, y), maxFloor - 1);
                }

                // exclude lowest
                if (clue == 2 && grid.solution(coord.offset(1, y))
                        .filter(it -> it == maxFloor)
                        .isEmpty()) {
                    grid.exclude(coord.offset(0, y), 1);
                }

                if (clue == 2 && grid.solution(coord.offset(maxFloor - 1, y))
                        .filter(it -> it == maxFloor)
                        .isPresent()) {
                    grid.solve(coord.offset(0, y), maxFloor - 1);
                }


                // mark lowest
                if (clue == 2 && grid.solution(coord.offset(2, y))
                        .filter(it -> it == maxFloor)
                        .isPresent()
                        && grid.solution(coord.offset(0, y))
                        .filter(it -> it == 2)
                        .isPresent()) {
                    grid.solve(coord.offset(1, y), 1);
                }

                // mark 2nd lowest
                if (clue == 3 && grid.solution(coord.offset(3, y))
                        .filter(it -> it == maxFloor)
                        .isPresent()
                        && grid.solution(coord.offset(2, y))
                        .filter(it -> it == 1)
                        .isPresent()) {
                    grid.solve(coord.offset(1, y), 3);
                }


                // grande finale
                if (clue == 3 && grid.solution(coord.offset(3, y))
                        .filter(it -> it == maxFloor)
                        .isPresent()
                        && grid.solution(coord.offset(2, y))
                        .filter(it -> it == maxFloor - 1)
                        .isPresent()) {
                    grid.solve(coord.offset(0, y), 2);
                }


            }
            System.out.println();
            coord = coord.rotateLeft();
        }
    }
}
