package year2023.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Puzzle2Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input2.txt, 281", "input.txt, 55260"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day1Puzzle2().readFileAndSolve(inputFile));
    }
}
