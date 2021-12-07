package days.day7;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day7Puzzle2Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 168", "input.txt, 99266250"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day7Puzzle2().readFileAndSolve(inputFile));
    }

    @Test
    void testGetExpendedFuel() {
        int fuel = new Day7Puzzle2().getExpendedFuel(ImmutableList.of(16,1,2,0,4,2,7,1,2,14), 2);

        assertEquals(206, fuel);
    }
}
