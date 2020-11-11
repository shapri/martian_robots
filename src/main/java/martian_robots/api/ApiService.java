package martian_robots.api;

import java.io.IOException;
import java.util.List;

public interface ApiService {

    void executeInstructions(List<String> instructions);

    void executeInstructionsFromFile(String filename) throws IOException;
}
