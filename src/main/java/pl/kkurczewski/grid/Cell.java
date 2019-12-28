package pl.kkurczewski.grid;

import pl.kkurczewski.grid.exception.cell.ExclusionConflictException;
import pl.kkurczewski.grid.exception.cell.SolveConflictException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cell {

    private final List<Integer> opts;

    public Cell(int maxFloors) {
        opts = IntStream.rangeClosed(1, maxFloors)
                .boxed()
                .collect(Collectors.toList());
    }

    public boolean exclude(int givenFloor) {
        if (solution().isPresent()) {
            int solution = solution().get();
            if (givenFloor == solution) {
                throw new ExclusionConflictException(solution);
            }
            return false;
        }

        return opts.remove(Integer.valueOf(givenFloor));
    }

    public boolean solve(int givenFloor) {
        if (solution().isPresent()) {
            int solution = solution().get();
            if (givenFloor != solution) {
                throw new SolveConflictException(givenFloor, solution);
            }
            return false;
        }

        opts.clear();
        opts.add(givenFloor);

        return true;
    }

    public Optional<Integer> solution() {
        return solved() ? Optional.of(opts.get(0)) : Optional.empty();
    }

    public boolean hasCandidate(int floor) {
        return !solved() && opts.contains(floor);
    }

    public boolean hasSolution(int floor) {
        return solution().filter(it -> it == floor).isPresent();
    }

    private boolean solved() {
        return opts.size() == 1;
    }
}
