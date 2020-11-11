package martian_robots.robot;

import martian_robots.SpringIntegrationTest;
import martian_robots.config.Configuration;
import martian_robots.model.Coordinate;
import martian_robots.model.Instruction;
import martian_robots.model.Orientation;
import martian_robots.model.Position;
import martian_robots.planet.PlanetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotServiceTest extends SpringIntegrationTest {

    @Autowired
    private PlanetService planetService;

    @Autowired
    private RobotService robotService;

    @BeforeEach
    public void setup() {
        planetService.setTopRightCoordinates(new Coordinate(5, 3));
    }

    @Test
    void turnLeftShouldFaceNorth() {
        planetService.setTopRightCoordinates(new Coordinate(5, 3));
        robotService.moveRobot(0, new Position(new Coordinate(1,1), Orientation.E), Arrays.asList(Instruction.L));
        assertEquals("1 1 N", robotService.getRobotStatus(0));
    }

    @Test
    void turnRightShouldFaceSouth() {
        planetService.setTopRightCoordinates(new Coordinate(5, 3));
        robotService.moveRobot(0, new Position(new Coordinate(1,1), Orientation.E), Arrays.asList(Instruction.R));
        assertEquals("1 1 S", robotService.getRobotStatus(0));
    }

    @Test
    void moveForwardShouldBeInsideGrid() {
        planetService.setTopRightCoordinates(new Coordinate(5, 3));
        robotService.moveRobot(0, new Position(new Coordinate(1,1), Orientation.E), Arrays.asList(Instruction.F));
        assertEquals("2 1 E", robotService.getRobotStatus(0));
    }

    @Test
    void moveForwardShouldBeLost() {

        planetService.setTopRightCoordinates(new Coordinate(5, 3));
        robotService.moveRobot(0, new Position(new Coordinate(5,3), Orientation.E), Arrays.asList(Instruction.F));
        assertEquals("5 3 E LOST", robotService.getRobotStatus(0));
    }
}