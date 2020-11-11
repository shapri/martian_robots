package martian_robots.robot;

import martian_robots.model.Coordinate;
import martian_robots.model.Instruction;
import martian_robots.model.Position;
import martian_robots.planet.PlanetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RobotImpl implements Robot {

    private static Logger LOG = LoggerFactory.getLogger(RobotImpl.class);

    private PlanetService planetService;
    private static String STATUS_LOST = "LOST";
    private Position position;
    private String status = "";

    public RobotImpl(PlanetService planetService) {
        this.planetService = planetService;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        status = "";
    }

    public void move(Instruction i) {

        if(status.equals(STATUS_LOST) ) // ignore instruction if already LOST
            return;

        switch(i){
            case L: turnLeft();
                break;
            case R: turnRight();
                break;
            case F: moveForward();
                break;
            default:
                break;
        }
    }

    private void turnLeft() {
        position = new Position( new Coordinate(position.getCoordinate().getX(), position.getCoordinate().getY()), position.getOriantation().turnLeft());
    }

    private void turnRight() {
        position = new Position( new Coordinate(position.getCoordinate().getX(), position.getCoordinate().getY()), position.getOriantation().turnRight());
    }

    private void moveForward() {

        if(planetService.isScentPresent(position) ) // ignore instruction to avoid getting LOST
            return;

        Position newPosition = position;

        switch(position.getOriantation()) {
            case N: newPosition = new Position( new Coordinate(position.getCoordinate().getX(), position.getCoordinate().getY()+1), position.getOriantation());
                break;
            case S: newPosition = new Position( new Coordinate(position.getCoordinate().getX(), position.getCoordinate().getY()-1), position.getOriantation());
                break;
            case E: newPosition = new Position( new Coordinate(position.getCoordinate().getX()+1, position.getCoordinate().getY()), position.getOriantation());
                break;
            case W: newPosition = new Position( new Coordinate(position.getCoordinate().getX()-1, position.getCoordinate().getY()), position.getOriantation());
                break;
        }

        // Not sure if this makes sense. Should we be able record scent after we are lost?
        // An alternative approach may be more appropriate but need clarification on requirements
        if( !planetService.isCoordinateInsideGrid(newPosition.getCoordinate()) ) { //set scent and status if we are about to get lost
            setScent();
            setStatusToLost();
        }
        else
            position = newPosition;
    }

    private void setScent(){
        planetService.setScent(position);
    }

    private void setStatusToLost() {
        this.status = STATUS_LOST;
    }

    public String getStatus() {
        return toString();
    }

    @Override
    public String toString() {

        if(status.isEmpty())
            return position.toString();
        else
            return position + " " + status;
    }
}
