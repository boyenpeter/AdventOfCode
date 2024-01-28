package year2023.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Puzzle1Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 8", "input.txt, 2545"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day2Puzzle1().readFileAndSolve(inputFile));
    }
}
