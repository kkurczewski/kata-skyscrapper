package pl.kkurczewski.grid.exception.core;

import pl.kkurczewski.grid.Coord;

import static java.lang.String.format;

public class ExcludeFailedException extends IllegalStateException {

    public ExcludeFailedException(Coord coord, int floor, Throwable ex) {
        super(format("Failed to exclude floor %s for %s", floor, coord), ex);
    }
}
