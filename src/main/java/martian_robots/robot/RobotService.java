package martian_robots.robot;

import martian_robots.model.Instruction;
import martian_robots.model.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RobotService {

    void moveRobot(int robotId, Position initialPosition, List<Instruction> instructions);

    List<String> getRobotStatus();

    String getRobotStatus(int robotId);
}
