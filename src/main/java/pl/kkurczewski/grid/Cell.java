package pl.kkurczewski.grid;

import pl.kkurczewski.grid.exception.cell.ExclusionConflictException;
import pl.kkurczewski.grid.exception.cell.SolveConflictException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cell {

    private final List<Integer> opts;
    private int solution = 0;

    Cell(int maxFloors) {
        opts = IntStream.rangeClosed(1, maxFloors)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * @return remaining candidates or empty list if no change happened
     */
    List<Integer> exclude(int givenFloor) {
        if (solved()) {
            if (givenFloor == solution) {
                throw new ExclusionConflictException(solution);
            }
            return new ArrayList<>();
        }

        return opts.remove(Integer.valueOf(givenFloor)) ? List.copyOf(opts) : new ArrayList<>();
    }

    public boolean solve(int givenFloor) {
        if (solved()) {
            if (givenFloor != solution) {
                throw new SolveConflictException(givenFloor, solution);
            }
            return false;
        }

        opts.clear();
        solution = givenFloor;

        return true;
    }

    /**
     * @return solution or zero if not solved yet
     */
    public int solution() {
        return solution;
    }

    boolean hasCandidate(int floor) {
        return !solved() && opts.contains(floor);
    }

    boolean hasSolution(int floor) {
        return solution == floor;
    }

    private boolean solved() {
        return opts.isEmpty();
    }
}
