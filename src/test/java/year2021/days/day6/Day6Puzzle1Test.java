package year2021.days.day6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import year2021.days.day6.Day6Puzzle1;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6Puzzle1Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 5934", "input.txt, 395627"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day6Puzzle1().readFileAndSolve(inputFile));
    }

    @Test
    void testIntermediateSolution() {
        assertEquals(26, new Day6Puzzle1().simulate("3,4,3,1,2", 18));
    }
}
