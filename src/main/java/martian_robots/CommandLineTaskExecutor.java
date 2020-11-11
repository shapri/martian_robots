package martian_robots;

import martian_robots.api.ApiService;
import martian_robots.robot.RobotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Profile("!test")
@Component
public class CommandLineTaskExecutor implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(CommandLineTaskExecutor.class);

    @Autowired
    private ApiService apiService;

    @Autowired
    private RobotService robotService;

    @Override
    public void run(String ...args) throws IOException {

        if(args.length != 1)
            System.out.println("usage java -jar <uber-jar-name> /absolute/path/to/instructions/file");

        String pathToFile = args[0];
        LOG.info("program started");

        apiService.executeInstructionsFromFile(pathToFile);
        robotService.getRobotStatus().forEach(System.out::println);
    }

}