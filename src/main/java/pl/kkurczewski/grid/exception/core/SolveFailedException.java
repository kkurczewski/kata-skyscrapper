package pl.kkurczewski.grid.exception.core;

import static java.lang.String.format;

public class SolveFailedException extends IllegalStateException {

    public SolveFailedException(int x, int y, int floor, Throwable ex) {
        super(format("Failed to set floor %s as solution for (%s,%s)", floor, x, y), ex);
    }
}
