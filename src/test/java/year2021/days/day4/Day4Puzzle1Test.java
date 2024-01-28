package year2021.days.day4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import year2021.days.day4.Day4Puzzle1;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Puzzle1Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 4512", "input.txt, 16716"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day4Puzzle1().readFileAndSolve(inputFile));
    }
}
