package martian_robots.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@RequiredArgsConstructor
public class Coordinate {

    private final int x;
    private final int y;

    @Override
    public String toString() {
        return x + " " + y;
    }
}
