package martian_robots.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrientationTest {

    @Test
    public void NorthFacingTurnRightShouldBeEast() {
        assertEquals(Orientation.E, Orientation.N.turnRight());
    }

    @Test
    public void NorthFacingTurnLeftShouldBeWest() {
        assertEquals(Orientation.W, Orientation.N.turnLeft());
    }

    @Test
    public void EastFacingTurnRightShouldBeEast() {
        assertEquals(Orientation.S, Orientation.E.turnRight());
    }

    @Test
    public void EastFacingTurnLeftShouldBeWest() {
        assertEquals(Orientation.N, Orientation.E.turnLeft());
    }

    @Test
    public void SouthFacingTurnRightShouldBeWest() {
        assertEquals(Orientation.W, Orientation.S.turnRight());
    }

    @Test
    public void SouthFacingTurnLeftShouldBeEast() {
        assertEquals(Orientation.E, Orientation.S.turnLeft());
    }

    @Test
    public void WestFacingTurnRightShouldBeNorth() {
        assertEquals(Orientation.N, Orientation.W.turnRight());
    }

    @Test
    public void WestFacingTurnLeftShouldBeSouth() {
        assertEquals(Orientation.S, Orientation.W.turnLeft());
    }


}