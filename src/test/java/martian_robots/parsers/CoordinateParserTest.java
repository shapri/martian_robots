package martian_robots.parsers;

import martian_robots.model.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinateParserTest {

    @Test
    public void parseSurfaceTopRightCoordinateTest() {
        Coordinate expected = new Coordinate(5, 3);
        Coordinate actual = CoordinateParser.parseSurfaceTopRightCoordinate("5 3");
        assertEquals(expected, actual);
    }
}