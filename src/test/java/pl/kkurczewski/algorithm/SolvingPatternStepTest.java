//package pl.kkurczewski.algorithm;
//
//
//import org.junit.jupiter.api.Test;
//import pl.kkurczewski.algorithm.util.Coord;
//import pl.kkurczewski.grid.Grid;
//import pl.kkurczewski.grid.LoggingGrid;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
// FIXME
//public class SolvingPatternStepTest {
//
//    @Test
//    public void insufficientMatch() {
//        SolvingPatternStep solvingPatternStep = new SolvingPatternStep(2, List.of(0, 0, 4, 3), List.of(2, 1, 4, 3));
//
//        List<String> logs = new ArrayList<>();
//        Grid grid = new LoggingGrid(new Grid(4), logs::add);
//        assertThat(solvingPatternStep.apply(grid, new Coord(10,0), 2, 0))List.of(0, 0, 0, 0))).isEmpty();
//        assertThat(solvingPatternStep.apply(grid, 2, List.of(0, 0, 4, 0))).isEmpty();
//        assertThat(solvingPatternStep.apply(grid, 2, List.of(0, 0, 0, 3))).isEmpty();
//        assertThat(solvingPatternStep.apply(grid, 0, List.of(0, 0, 4, 3))).isEmpty();
//    }
//
//    @Test
//    public void failedMatch() {
//        SolvingPatternStep solvingPatternStep = new SolvingPatternStep(2, List.of(0, 0, 4, 3), List.of(2, 1, 4, 3));
//
//        assertThat(solvingPatternStep.apply(grid, 2, List.of(0, 3, 4, 0))).isEmpty();
//        assertThat(solvingPatternStep.apply(grid, 2, List.of(0, 0, 2, 1))).isEmpty();
//
//        assertThat(solvingPatternStep.apply(grid, 3, List.of(0, 0, 0, 0))).isEmpty();
//        assertThat(solvingPatternStep.apply(grid, 3, List.of(0, 0, 4, 3))).isEmpty();
//
//        assertThat(solvingPatternStep.apply(grid, 2, List.of(0, 0, -4, 3))).isEmpty();
//        assertThat(solvingPatternStep.apply(grid, 2, List.of(0, 0, 4, -3))).isEmpty();
//        assertThat(solvingPatternStep.apply(grid, 2, List.of(0, 0, -4, -3))).isEmpty();
//    }
//
//    @Test
//    public void match() {
//        SolvingPatternStep solvingPatternStep = new SolvingPatternStep(2, List.of(0, 0, 4, 3), List.of(2, 1, 4, 3));
//
//        assertThat(solvingPatternStep.apply(grid, 2, List.of(0, 0, 4, 3))).containsOnly(2, 1, 4, 3);
//        assertThat(solvingPatternStep.apply(grid, 2, List.of(0, 1, 4, 3))).containsOnly(2, 1, 4, 3);
//        assertThat(solvingPatternStep.apply(grid, 2, List.of(2, 0, 4, 3))).containsOnly(2, 1, 4, 3);
//    }
//
//    @Test
//    public void exclusion() {
//        SolvingPatternStep solvingPatternStep = new SolvingPatternStep(2, List.of(0, 0, 4, 0), List.of(-1, 0, 0, 0));
//
//        assertThat(solvingPatternStep.apply(grid, 2, List.of(0, 0, 4, 0))).containsOnly(-1, 0, 0, 0);
//    }
//}