package martian_robots.parsers;

import martian_robots.model.Instruction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstructionParserTest {

    @Test
    public void parseInstructionsTest() {
        List<Instruction> instructions = InstructionParser.parseInstructions("RF");
        assertEquals(2, instructions.size());
        assertEquals(Instruction.R, instructions.get(0));
        assertEquals(Instruction.F, instructions.get(1));
    }
}