package pl.kkurczewski.grid;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.kkurczewski.grid.exception.failfast.InvalidExclusionException;
import pl.kkurczewski.grid.exception.failfast.InvalidSolutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FailFastGridTest {

    private final int[][] solution = {
            {1, 3, 4, 2},
            {4, 2, 1, 3},
            {3, 4, 2, 1},
            {2, 1, 3, 4}
    };

    @Test
    public void shouldThrowExceptionWhenConflictingSolution() {
        Executable action = () -> new FailFastGrid(solution).solve(0, 0, 4);
        InvalidSolutionException ex = assertThrows(InvalidSolutionException.class, action);

        assertThat(ex).hasMessage("Floor 4 is incorrect solution for (0,0), correct one is 1");
    }

    @Test
    public void shouldThrowExceptionWhenConflictingExclusion() {
        Executable action = () -> new FailFastGrid(solution).exclude(0, 0, 1);
        InvalidExclusionException ex = assertThrows(InvalidExclusionException.class, action);

        assertThat(ex).hasMessage("Floor 1 is correct solution at (0,0)");
    }
}