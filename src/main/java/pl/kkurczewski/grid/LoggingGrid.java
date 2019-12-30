package pl.kkurczewski.grid;

import java.util.function.Consumer;

import static java.lang.String.format;

public class LoggingGrid extends Grid {

    private final Consumer<String> logger;

    public LoggingGrid(Grid rootGrid, Consumer<String> logger) {
        super(rootGrid);
        this.logger = logger;
    }

    @Override
    public boolean solve(Coord coord, int givenFloor) {
        boolean changed = super.solve(coord, givenFloor);
        if (changed) {
            logger.accept(format("%s == %s", coord, givenFloor));
        }
        return changed;
    }

    @Override
    public boolean exclude(Coord coord, int floor) {
        boolean changed = super.exclude(coord, floor);
        if (changed) {
            logger.accept(format("%s != %s", coord, floor));
        }
        return changed;
    }
}
