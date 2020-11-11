package martian_robots.config;

import martian_robots.planet.Planet;
import martian_robots.planet.PlanetImpl;
import martian_robots.planet.PlanetService;
import martian_robots.planet.PlanetServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

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

}
