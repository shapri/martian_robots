package martian_robots.api;

import martian_robots.SpringIntegrationTest;
import martian_robots.robot.RobotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
public class ApiServiceTest extends SpringIntegrationTest {

    @Autowired
    private ApiService apiService;

    @Autowired
    private RobotService robotService;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void executeListOfInstructionsOneRobot() {

        List<String> instructions = new ArrayList<>();
        instructions.add("5 3");
        instructions.add("1 1 E");
        instructions.add("RFRFRFRF");

        apiService.executeInstructions(instructions );
        assertEquals("1 1 E", robotService.getRobotStatus(0));
    }


    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void executeListOfInstructionsTwoRobots() {

        List<String> instructions = new ArrayList<>();
        instructions.add("5 3");
        instructions.add("1 1 E");
        instructions.add("RFRFRFRF");
        instructions.add("3 2 N");
        instructions.add("FRRFLLFFRRFLL");

        apiService.executeInstructions(instructions );
        assertEquals("1 1 E", robotService.getRobotStatus(0));
        assertEquals("3 3 N LOST", robotService.getRobotStatus(1));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void executeListOfInstructionsThreeRobots() {

        List<String> instructions = new ArrayList<>();
        instructions.add("5 3");
        instructions.add("1 1 E");
        instructions.add("RFRFRFRF");
        instructions.add("3 2 N");
        instructions.add("FRRFLLFFRRFLL");
        instructions.add("0 3 W");
        instructions.add("LLFFFLFLFL");

        apiService.executeInstructions(instructions );
        assertEquals("1 1 E", robotService.getRobotStatus(0));
        assertEquals("3 3 N LOST", robotService.getRobotStatus(1));
        assertEquals("2 3 S", robotService.getRobotStatus(2));
    }








}
