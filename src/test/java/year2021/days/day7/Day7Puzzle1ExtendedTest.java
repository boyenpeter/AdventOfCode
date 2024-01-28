package year2021.days.day7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import year2021.days.day7.Day7Puzzle1;
import year2021.days.day7.Day7Puzzle1Extended;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day7Puzzle1ExtendedTest {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 37", "input.txt, 352331"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day7Puzzle1Extended().readFileAndSolve(inputFile));
    }

    @Test
    void testSameResult() {
        Random r = new Random();

        for(int i = 0; i < 1000; i++) {
            List<Integer> input = IntStream.generate(() -> r.nextInt(1000))
                    .limit(r.nextInt(99) + 1)
                    .boxed()
                    .collect(Collectors.toList());

            assertEquals(new Day7Puzzle1().solve(input), new Day7Puzzle1Extended().solve(input), "input: " + input);
        }
    }
}
