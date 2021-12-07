package days.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Puzzle1Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 7", "input.txt, 1521"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day1Puzzle1().readFileAndSolve(inputFile));
    }
}
