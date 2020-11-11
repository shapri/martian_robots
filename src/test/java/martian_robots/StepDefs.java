package martian_robots;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import martian_robots.api.ApiService;
import martian_robots.config.Configuration;
import martian_robots.robot.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@ContextConfiguration(classes = Configuration.class)

public class StepDefs {

    @Autowired
    private ApiService apiService;

    @Autowired
    private RobotService robotService;

    private List<String> instructions;

    @Given("the following instructions")
    public void the_following_instructions(String docString) {
        instructions = Arrays.asList(docString.split("\n") );
    }

    @When("instructions are executed")
    public void instructions_are_executed() {
       apiService.executeInstructions( instructions );
    }

    @Then("status for each robot should be:")
    public void status_for_each_robot_should_be(DataTable dataTable) {

        Map<Integer, String> s = dataTable.rows(1).asMap(Integer.class, String.class);

        for( Integer robotId : s.keySet() )
        {
            String actualStatus = robotService.getRobotStatus(robotId);
            String expectedStatus = s.get(robotId);
            assertEquals(expectedStatus, actualStatus);
        }
    }


}