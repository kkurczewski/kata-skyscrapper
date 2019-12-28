package pl.kkurczewski.grid.exception.failfast;

import pl.kkurczewski.grid.Coord;

import static java.lang.String.format;

public class InvalidSolutionException extends IllegalArgumentException {

    public InvalidSolutionException(int expectedFloor, int givenFloor, Coord coord) {
        super(format("Floor %s is incorrect solution for %s, correct one is %s", givenFloor, coord, expectedFloor));
    }
}
