package pl.kkurczewski.grid.exception.failfast;

import static java.lang.String.format;

public class InvalidSolutionException extends IllegalArgumentException {

    public InvalidSolutionException(int x, int y, int expectedFloor, int givenFloor) {
        super(format("Floor %s is incorrect solution for (%s,%s), correct one is %s", givenFloor, x, y, expectedFloor));
    }
}
