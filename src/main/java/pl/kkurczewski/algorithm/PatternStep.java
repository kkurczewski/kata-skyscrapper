package pl.kkurczewski.algorithm;

import pl.kkurczewski.algorithm.util.Coord;
import pl.kkurczewski.grid.Grid;

@FunctionalInterface
public interface PatternStep {
    void apply(Grid grid, Coord coord, int clue, int y);
}
