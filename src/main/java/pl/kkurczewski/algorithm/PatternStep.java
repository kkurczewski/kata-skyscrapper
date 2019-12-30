package pl.kkurczewski.algorithm;

import pl.kkurczewski.algorithm.util.CoordLens;
import pl.kkurczewski.grid.Grid;

@FunctionalInterface
public interface PatternStep {
    void apply(Grid grid, CoordLens coord, int clue, int y);
}
