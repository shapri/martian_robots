package martian_robots.parsers;

import martian_robots.model.Instruction;

import java.util.ArrayList;
import java.util.List;

public class InstructionParser {

    // e.g. RFRFRFRF
    public static List<Instruction> parseInstructions(String line) {
        List<Instruction> instructions = new ArrayList<>();
        for (String instruction : line.split(""))
            instructions.add(Instruction.valueOf(instruction));
        return instructions;
    }

}
