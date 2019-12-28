package pl.kkurczewski.grid.exception.failfast;

import pl.kkurczewski.grid.Coord;

import static java.lang.String.format;

public class InvalidExclusionException extends IllegalArgumentException {

    public InvalidExclusionException(int floor, Coord coord) {
        super(format("Floor %s is correct solution at %s", floor, coord));
    }
}
