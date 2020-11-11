package martian_robots.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@RequiredArgsConstructor
public class Position {

    private final Coordinate coordinate;
    private final Orientation oriantation;

    @Override
    public String toString() {
        return coordinate + " " + oriantation;
    }
}
