package year2023.day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Puzzle1Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 4361", "input.txt, 546563"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day3Puzzle1().readFileAndSolve(inputFile));
    }
}
