package pl.kkurczewski;

import pl.kkurczewski.grid.Grid;
import pl.kkurczewski.solver.Solver;

public class SkyScrapers {

    static int[][] solvePuzzle(int[] clues) {
        int maxFloor = (int) Math.sqrt(clues.length);
        Solver solver = new Solver(new Grid(maxFloor), clues);

        return solver.solve(new FinalAlgorithm());
    }
}
