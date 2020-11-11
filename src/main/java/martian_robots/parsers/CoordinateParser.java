package martian_robots.parsers;

import martian_robots.model.Coordinate;

public class CoordinateParser {

    // e.g. "5 3"
    public static Coordinate parseSurfaceTopRightCoordinate(String str) {
        String[] arr = str.split(" ");

        if(arr.length < 2)
            throw new IllegalArgumentException("There should be two characters defining top right coordinate");

        int xCoordinate     = Integer.parseInt(arr[0]);
        int yCoordinate     = Integer.parseInt(arr[1]);

        return new Coordinate(xCoordinate, yCoordinate);
    }

}
