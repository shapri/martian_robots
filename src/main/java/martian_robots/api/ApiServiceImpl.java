package martian_robots.api;

import martian_robots.model.Instruction;
import martian_robots.model.Position;
import martian_robots.parsers.CoordinateParser;
import martian_robots.parsers.InstructionParser;
import martian_robots.parsers.PositionParser;
import martian_robots.planet.PlanetService;
import martian_robots.robot.RobotService;
import martian_robots.robot.RobotServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ApiServiceImpl implements ApiService {

    private static Logger LOG = LoggerFactory.getLogger(RobotServiceImpl.class);

    private static int MAX_INSTRUCTION_LENGTH   = 100;

    private PlanetService planetService;
    private RobotService robotService;

    public ApiServiceImpl(PlanetService planetService, RobotService robotService) {
        this.planetService = planetService;
        this.robotService = robotService;
    }

    @Override
    public void executeInstructionsFromFile(String filename) throws IOException {
        List<String> instructions = Files.lines(Paths.get(filename)).collect(Collectors.toList());
        executeInstructions(instructions);
    }

    @Override
    public void executeInstructions(List<String> _instructions) {

        List<String> instructions = cleanUpAndValidate(_instructions);
        configurePlanet(instructions);
        moveRobots(instructions);
    }

    private void configurePlanet(List<String> instructions){
        String topRightCoordinate = instructions.get(0);
        planetService.setTopRightCoordinates(CoordinateParser.parseSurfaceTopRightCoordinate(topRightCoordinate));
    }

    private void moveRobots(List<String> instructions) {

        int robotId = 0;
        for( int i=1; i<instructions.size(); i+=2) {

            Position initial = PositionParser.parseInitialRobotPosition(instructions.get(i));
            List<Instruction> _instructions = InstructionParser.parseInstructions(instructions.get(i+1));
            robotService.moveRobot(robotId, initial, _instructions);
            robotId++;
        }
    }

    private List<String> cleanUpAndValidate(List<String> _instructions){

        // remove blank lines
        List<String> instructions = _instructions.stream().filter( e-> !e.isBlank() ).collect(Collectors.toList());

        if(instructions.size() < 1)
            throw new RuntimeException("Invalid instruction file");

        if(instructions.size() == 1)
            throw new RuntimeException("No Robot instructions in file");

        if(instructions.size()%2 == 0) // should be even number of lines
            throw new RuntimeException("Robot instructions should be two lines per robot");

        for( int i=3; i<instructions.size(); i+=3) {
            if (instructions.get(i).length() > MAX_INSTRUCTION_LENGTH) {
                String err = String.format("Line %d exceeds maximum length (%d) for robot instructions", i, MAX_INSTRUCTION_LENGTH);
                throw new IllegalArgumentException(err);
            }
        }

        return instructions;
    }
}
