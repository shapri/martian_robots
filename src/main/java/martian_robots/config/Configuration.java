package martian_robots.config;

import martian_robots.planet.Planet;
import martian_robots.planet.PlanetImpl;
import martian_robots.planet.PlanetService;
import martian_robots.planet.PlanetServiceImpl;
import martian_robots.robot.Robot;
import martian_robots.robot.RobotImpl;
import martian_robots.robot.RobotService;
import martian_robots.robot.RobotServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration {

    private static Logger LOG = LoggerFactory.getLogger(Configuration.class);

    @Bean
    public Planet planet() {
        return new PlanetImpl();
    }

    @Bean
    public PlanetService planetService() {
        return new PlanetServiceImpl(planet());
    }

    @Bean
    public List<Robot> robots() {
        List<Robot> robots = new ArrayList<>();

        for(int i=0; i<3; i++)
            robots.add(new RobotImpl(planetService()));

        return robots;
    }

    @Bean
    public RobotService robotService(){
        return new RobotServiceImpl(planetService(), robots() );
    }
}
