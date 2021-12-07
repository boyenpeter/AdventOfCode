package days.day6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6Puzzle2Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 26984457539", "input.txt, 1767323539209"})
    void testGetSolutionTestInput(String inputFile, long expected) {
        assertEquals(expected, new Day6Puzzle2().readFileAndSolve(inputFile));
    }
}
