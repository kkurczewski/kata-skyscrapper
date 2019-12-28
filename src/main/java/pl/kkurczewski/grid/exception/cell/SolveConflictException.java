package pl.kkurczewski.grid.exception.cell;

import static java.lang.String.format;

public class SolveConflictException extends IllegalStateException {

    public SolveConflictException(int newSolution, int oldSolution) {
        super(format("Failed to set floor %s as solution because already marked as %s", newSolution, oldSolution));
    }
}
