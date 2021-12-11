package days.day9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day9Puzzle2Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 1134", "input.txt, 1198704"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day9Puzzle2().readFileAndSolve(inputFile));
    }
}
