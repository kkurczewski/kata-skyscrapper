package pl.kkurczewski.algorithm;

import pl.kkurczewski.grid.Grid;
import pl.kkurczewski.solver.Algorithm;

public class NamedAlgorithm implements Algorithm {

    private final String name;
    private final Algorithm algorithm;

    private NamedAlgorithm(String name, Algorithm algorithm) {
        this.name = name;
        this.algorithm = algorithm;
    }

    public static Algorithm named(String name, Algorithm algorithm) {
        return new NamedAlgorithm(name, algorithm);
    }

    @Override
    public void solve(Grid grid, int[][] clues) {
        System.out.println(name);
        algorithm.solve(grid, clues);
    }
}
