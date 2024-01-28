package year2021.days.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import year2021.days.day1.Day1Puzzle2;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Puzzle2Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 5", "input.txt, 1543"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day1Puzzle2().readFileAndSolve(inputFile));
    }
}
