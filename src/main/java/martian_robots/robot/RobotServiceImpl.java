package martian_robots.robot;

import martian_robots.model.Instruction;
import martian_robots.model.Position;
import martian_robots.planet.PlanetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class RobotServiceImpl implements RobotService {

    private static Logger LOG = LoggerFactory.getLogger(RobotServiceImpl.class);

    private static int MAX_INSTRUCTION_LENGTH = 100;

    private PlanetService planetService;

    private List<Robot> robots;

    public RobotServiceImpl(PlanetService planetService, List<Robot> robots) {
        this.planetService = planetService;
        this.robots = robots;
    }

    public void moveRobot(int robotId, Position initialPosition, List<Instruction> instructions){
        Robot robot = robots.get(robotId);
        robot.setPosition(initialPosition);
        instructions.forEach(robot::move);
    }

    public List<String> getRobotStatus() {
        return robots.stream().map(Robot::getStatus).collect(Collectors.toList());
    }

    public String getRobotStatus(int robotId){
        return robots.get(robotId).getStatus();
    }
}
