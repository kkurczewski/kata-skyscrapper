package pl.kkurczewski.grid.exception.core;

import pl.kkurczewski.grid.Coord;

import static java.lang.String.format;

public class SolveFailedException extends IllegalStateException {

    public SolveFailedException(Coord coord, int floor, Throwable ex) {
        super(format("Failed to set floor %s as solution for %s", floor, coord), ex);
    }
}
