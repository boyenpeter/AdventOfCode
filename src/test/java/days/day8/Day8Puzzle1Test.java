package days.day8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8Puzzle1Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 26", "input.txt, 274"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day8Puzzle1().readFileAndSolve(inputFile));
    }
}
