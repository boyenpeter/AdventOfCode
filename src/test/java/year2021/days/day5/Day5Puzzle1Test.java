package year2021.days.day5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import year2021.days.day5.Day5Puzzle1;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5Puzzle1Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 5", "input.txt, 5698"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day5Puzzle1().readFileAndSolve(inputFile));
    }
}
