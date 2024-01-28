package year2021.days.day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import year2021.days.day3.Day3Puzzle1;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Puzzle1Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 198", "input.txt, 4147524"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day3Puzzle1().readFileAndSolve(inputFile));
    }
}
