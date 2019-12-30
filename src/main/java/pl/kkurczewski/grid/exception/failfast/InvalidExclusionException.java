package pl.kkurczewski.grid.exception.failfast;

import static java.lang.String.format;

public class InvalidExclusionException extends IllegalArgumentException {

    public InvalidExclusionException(int x, int y, int floor) {
        super(format("Floor %s is correct solution at (%s,%s)", floor, x, y));
    }
}
