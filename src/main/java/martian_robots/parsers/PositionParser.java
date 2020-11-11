package martian_robots.parsers;

import martian_robots.model.Coordinate;
import martian_robots.model.Orientation;
import martian_robots.model.Position;

public class PositionParser {

    // e.g. "1 1 E"
    public static Position parseInitialRobotPosition(String str) {
        String[] arr = str.split(" ");

        if(arr.length < 3)
            throw new IllegalArgumentException("There should be three characters defining a landing");

        int xCoordinate     = Integer.parseInt(arr[0]);
        int yCoordinate     = Integer.parseInt(arr[1]);
        String orientation  = arr[2];

        return new Position( new Coordinate(xCoordinate, yCoordinate), Orientation.valueOf(orientation) );
    }

}
