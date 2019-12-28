package pl.kkurczewski.grid;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cell {
    private final List<Integer> opts;

    Cell(int maxFloors) {
        opts = IntStream.rangeClosed(1, maxFloors)
                .boxed()
                .collect(Collectors.toList());
    }

    boolean exclude(int floorsNumber) {
        if (solution().filter(solution -> solution == floorsNumber).isPresent()) {
            throw new IllegalStateException("Conflicting solution, want exclude: "
                    + floorsNumber + " which is marked as solution");
        } else if (solved()) {
            return false;
        }

        return opts.remove(Integer.valueOf(floorsNumber));
    }

    boolean solve(int floorsNumber) {
        if (solution().filter(solution -> solution != floorsNumber).isPresent()) {
            throw new IllegalStateException("Conflicting solution, has: " + solution().orElseThrow() + ", got: " + floorsNumber);
        } else if (solved()) {
            return false;
        }

        opts.clear();
        opts.add(floorsNumber);

        return true;
    }

    Optional<Integer> solution() {
        return solved() ? Optional.of(opts.get(0)) : Optional.empty();
    }

    boolean hasCandidate(int candidate) {
        return !solved() && opts.contains(candidate);
    }

    boolean solved() {
        return opts.size() == 1;
    }

    public String toString() {
        return solution().map(String::valueOf).orElse(opts.size() > 2 ? "?" : "!");
    }

    public boolean hasSolution(int floorsNumber) {
        return solution().filter(it -> it == floorsNumber).isPresent();
    }
}
