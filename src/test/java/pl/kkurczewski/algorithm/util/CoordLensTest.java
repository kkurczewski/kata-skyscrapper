package pl.kkurczewski.algorithm.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordLensTest {

    @Test
    public void withoutRotation() {
        CoordLens lens = new CoordLens(3);

        assertThat(lens.coord(0, 0).toArray()).containsExactly(0, 0);
    }

    @Test
    public void afterRotation() {
        CoordLens lens = new CoordLens(3);
        lens.rotateLeft();
        assertThat(lens.coord(0, 0).toArray()).containsExactly(0, 3);

        lens.rotateLeft();
        assertThat(lens.coord(0, 0).toArray()).containsExactly(3, 3);

        lens.rotateLeft();
        assertThat(lens.coord(0, 0).toArray()).containsExactly(3, 0);

        lens.rotateLeft();
        assertThat(lens.coord(0, 0).toArray()).containsExactly(0, 0);
    }

    @Test
    public void rotationAfterOffset() {
        CoordLens lens = new CoordLens(3);
        lens.rotateLeft();
        assertThat(lens.coord(1, 1).toArray()).containsExactly(1, 2);
    }
}