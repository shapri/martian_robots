package martian_robots.planet;

import martian_robots.model.Coordinate;
import martian_robots.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class PlanetImpl implements Planet {

    private static Logger LOG = LoggerFactory.getLogger(PlanetImpl.class);

    private Coordinate bottomLeftCoordinate = new Coordinate(0,0);
    private Coordinate topRightCoordinate;

    @Override
    public void setTopRightCoordinates(Coordinate topRightCoordinate) {
        this.topRightCoordinate = topRightCoordinate;
    }

    private final Set<Position> scents = new HashSet<>();

    public void setScent(Position position) {
        scents.add(position);
    }

    public boolean isScentPresent(Position position) {
        return scents.contains(position);
    }

    public boolean isCoordinateInsideGrid(Coordinate coordinate){
        return  coordinate.getX() >= bottomLeftCoordinate.getX() &&
                coordinate.getX() <= topRightCoordinate.getX() &&
                coordinate.getY() >= bottomLeftCoordinate.getY() &&
                coordinate.getY() <= topRightCoordinate.getY();
    }


    @Override
    public String toString(){
        return  bottomLeftCoordinate + "," + topRightCoordinate;
    }
}
