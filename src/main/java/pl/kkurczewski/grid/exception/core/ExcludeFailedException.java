package pl.kkurczewski.grid.exception.core;

import static java.lang.String.format;

public class ExcludeFailedException extends IllegalStateException {

    public ExcludeFailedException(int x, int y, int floor, Throwable ex) {
        super(format("Failed to exclude floor %s for (%s,%s)", floor, x, y), ex);
    }
}
