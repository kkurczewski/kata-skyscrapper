package pl.kkurczewski.algorithm.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotatingCoordTest {

    @Test
    public void withoutRotation() {
        RotatingCoord coord = new RotatingCoord(0, 0, 4);
        assertEquals(0, coord.x());
        assertEquals(0, coord.y());
    }

    @Test
    public void afterRotation() {
        RotatingCoord oneRot = new RotatingCoord(0, 0, 4).rotateLeft();
        assertEquals(0, oneRot.x());
        assertEquals(3, oneRot.y());

        RotatingCoord twoRot = oneRot.rotateLeft();
        assertEquals(3, twoRot.x());
        assertEquals(3, twoRot.y());

        RotatingCoord threeRot = twoRot.rotateLeft();
        assertEquals(3, threeRot.x());
        assertEquals(0, threeRot.y());

        RotatingCoord fullRot = threeRot.rotateLeft();
        assertEquals(0, fullRot.x());
        assertEquals(0, fullRot.y());
    }

    @Test
    public void rotationAfterOffset() {
        RotatingCoord coord = new RotatingCoord(0, 0, 4)
                .offset(1,1)
                .rotateLeft();
        assertEquals(1, coord.x());
        assertEquals(2, coord.y());
    }
}