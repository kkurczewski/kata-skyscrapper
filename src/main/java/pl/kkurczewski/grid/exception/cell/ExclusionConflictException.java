package pl.kkurczewski.grid.exception.cell;

import static java.lang.String.format;

public class ExclusionConflictException extends IllegalStateException {

    public ExclusionConflictException(int exclusion) {
        super(format("Failed to exclude floor %s because it is marked as solution", exclusion));
    }
}
