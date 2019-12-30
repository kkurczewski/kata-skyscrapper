package pl.kkurczewski.grid;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LoggingGridTest {

    private final Grid emptyGrid = new Grid(4);

    @Test
    public void shouldLogSolveActions() {
        List<String> logs = new ArrayList<>();
        Grid grid = new LoggingGrid(emptyGrid, logs::add);

        grid.solve(1, 2, 1);

        assertThat(logs).containsOnly(
                "(1,2) == 1",
                "(1,0) != 1",
                "(1,1) != 1",
                "(1,3) != 1",
                "(0,2) != 1",
                "(2,2) != 1",
                "(3,2) != 1"
        );
    }

    @Test
    public void shouldLogExcludeActions() {
        List<String> logs = new ArrayList<>();
        Grid grid = new LoggingGrid(emptyGrid, logs::add);

        grid.exclude(1, 2, 1);

        assertThat(logs).containsOnly("(1,2) != 1");
    }

    @Test
    public void shouldLogLastValueInRow() {
        List<String> logs = new ArrayList<>();
        Grid grid = new LoggingGrid(emptyGrid, logs::add);

        grid.solve(0, 0, 1);
        grid.solve(0, 1, 4);
        grid.solve(0, 2, 2);

        assertThat(logs).contains("(0,3) == 3");
    }
}