package pl.kkurczewski.solver;

import pl.kkurczewski.grid.Grid;

public interface Algorithm {
    void solve(Grid grid, int[][] clues);
}
