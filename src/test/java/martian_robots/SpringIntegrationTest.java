package martian_robots;

import martian_robots.config.Configuration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ActiveProfiles("test")
@SpringBootTest
@ContextConfiguration(classes = Configuration.class)
public class SpringIntegrationTest {
}
