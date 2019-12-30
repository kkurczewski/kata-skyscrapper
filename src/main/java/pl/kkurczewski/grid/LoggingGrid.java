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
    public boolean solve(int x, int y, int givenFloor) {
        boolean changed = super.solve(x, y, givenFloor);
        if (changed) {
            logger.accept(format("(%s,%s) == %s", x, y, givenFloor));
        }
        return changed;
    }

    @Override
    public boolean exclude(int x, int y, int givenFloor) {
        boolean changed = super.exclude(x, y, givenFloor);
        if (changed) {
            logger.accept(format("(%s,%s) != %s", x, y, givenFloor));
        }
        return changed;
    }
}
