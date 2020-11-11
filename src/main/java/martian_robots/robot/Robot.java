package martian_robots.robot;

import martian_robots.model.Instruction;
import martian_robots.model.Position;

public interface Robot {

    void setPosition(Position position);
    void move(Instruction i);
    String getStatus();

}
