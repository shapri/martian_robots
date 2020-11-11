package martian_robots.planet;

import martian_robots.SpringIntegrationTest;
import martian_robots.config.Configuration;
import martian_robots.model.Coordinate;
import martian_robots.model.Orientation;
import martian_robots.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlanetServiceTest extends SpringIntegrationTest {

    @Autowired
    private PlanetService planetService;

    @BeforeEach
    public void setup() {
        planetService.setTopRightCoordinates(new Coordinate(5, 3));
    }

    @Test
    public void isScentPresentShouldReturnFalse() {

        Position p = new Position(new Coordinate(5,3), Orientation.N);
        assertFalse(planetService.isScentPresent(p));
    }

    @Test
    public void isScentPresentShouldReturnTrue() {

        Position p = new Position(new Coordinate(5,3), Orientation.N);
        planetService.setScent(p);
        assertTrue(planetService.isScentPresent(p));
    }

    @Test
    public void isCoordinateInsideGridNorthShouldBeTrue() {
        assertTrue(planetService.isCoordinateInsideGrid(new Coordinate(5,3)));
    }

    @Test
    public void isCoordinateInsideGridNorthShouldBeFalse() {
        assertFalse(planetService.isCoordinateInsideGrid(new Coordinate(5,4)));
    }

    @Test
    public void isCoordinateInsideGridEastShouldBeTrue() {
        assertTrue(planetService.isCoordinateInsideGrid(new Coordinate(5,0)));
    }

    @Test
    public void isCoordinateInsideGridEasthShouldBeFalse() {
        assertFalse(planetService.isCoordinateInsideGrid(new Coordinate(6,3)));
    }

    @Test
    public void isCoordinateInsideGridSouthShouldBeTrue() {
        assertTrue(planetService.isCoordinateInsideGrid(new Coordinate(0,0)));
    }

    @Test
    public void isCoordinateInsideGridSouthShouldBeFalse() {
        assertFalse(planetService.isCoordinateInsideGrid(new Coordinate(0,-1)));
    }

    @Test
    public void isCoordinateInsideGridWestShouldBeTrue() {
        assertTrue(planetService.isCoordinateInsideGrid(new Coordinate(0,3)));
    }

    @Test
    public void isCoordinateInsideGridWestShouldBeFalse() {
        assertFalse(planetService.isCoordinateInsideGrid(new Coordinate(-1,3)));
    }

}
