package days.day7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day7Puzzle1Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 37", "input.txt, 352331"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day7Puzzle1().readFileAndSolve(inputFile));
    }
}
