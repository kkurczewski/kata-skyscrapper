package pl.kkurczewski.algorithm;

import pl.kkurczewski.algorithm.util.ImmutableCoordLens;
import pl.kkurczewski.grid.Grid;

@FunctionalInterface
public interface PatternStep {
    void apply(Grid grid, ImmutableCoordLens lens, int clue, int y);
}
