package martian_robots.planet;

import martian_robots.model.Coordinate;
import martian_robots.model.Position;

public class PlanetServiceImpl implements PlanetService {

    private Planet planet;

    public PlanetServiceImpl(Planet planet) {
        this.planet = planet;
    }

    @Override
    public void setScent(Position position) {
        planet.setScent(position);
    }

    @Override
    public boolean isScentPresent(Position position) {
        return planet.isScentPresent(position);
    }

    @Override
    public boolean isCoordinateInsideGrid(Coordinate coordinate) {
        return planet.isCoordinateInsideGrid(coordinate);
    }

    @Override
    public void setTopRightCoordinates(Coordinate coordinates) {
        planet.setTopRightCoordinates(coordinates);
    }
}
