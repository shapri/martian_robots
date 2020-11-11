package martian_robots.planet;

import martian_robots.model.Coordinate;
import martian_robots.model.Position;

public interface Planet {

    void setScent(Position position);

    boolean isScentPresent(Position position);

    boolean isCoordinateInsideGrid(Coordinate coordinate);

    void setTopRightCoordinates(Coordinate coordinates);
}
