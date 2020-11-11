package martian_robots.parsers;

import martian_robots.model.Coordinate;
import martian_robots.model.Orientation;
import martian_robots.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionParserTest {

    @Test
    public void parseInitialRobotPositionTest() {

        Position expected = new Position( new Coordinate(1,1), Orientation.E);
        Position actual = PositionParser.parseInitialRobotPosition("1 1 E");
        assertEquals(expected, actual);
    }
}