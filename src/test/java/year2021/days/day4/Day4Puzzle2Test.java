package year2021.days.day4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import year2021.days.day4.Day4Puzzle2;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Puzzle2Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 1924", "input.txt, 4880"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day4Puzzle2().readFileAndSolve(inputFile));
    }
}
