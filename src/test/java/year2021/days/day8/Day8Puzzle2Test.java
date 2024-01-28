package year2021.days.day8;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import year2021.days.day8.Day8Puzzle2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static year2021.days.day8.Day8Puzzle2.canonical;
import static year2021.days.day8.Day8Puzzle2.containsAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8Puzzle2Test {
    @ParameterizedTest(name="{index}) File {0} gives result of {1}")
    @CsvSource({"test_input.txt, 61229", "input.txt, 1012089"})
    void testGetSolutionTestInput(String inputFile, int expected) {
        assertEquals(expected, new Day8Puzzle2().readFileAndSolve(inputFile));
    }

    @ParameterizedTest(name="{index}) Input {0} gives canonical result of {1}")
    @CsvSource({"acedgfb, abcdefg", "dab, abd", "ab,ab"})
    void testCanonical(String input, String expected) {
        assertEquals(expected, canonical(input));
    }

    @ParameterizedTest(name="{index}) Input {0} gives canonical result of {1}")
    @CsvSource({"acedgfb, abcdefg, true", "ace, ea, true", "ae, eca, false"})
    void testContainsAll(String input, String letters, boolean expected) {
        assertEquals(expected, containsAll(input, letters));
    }

    @Test
    void testUnscramble() {
        Map<String, Integer> expected = ImmutableMap.<String, Integer>builder()
                .put(canonical("acedgfb"), 8)
                .put(canonical("cdfbe"), 5)
                .put(canonical("gcdfa"), 2)
                .put(canonical("fbcad"), 3)
                .put(canonical("dab"), 7)
                .put(canonical("cefabd"), 9)
                .put(canonical("cdfgeb"), 6)
                .put(canonical("eafb"), 4)
                .put(canonical("cagedb"), 0)
                .put(canonical("ab"), 1).build();

        List<String> inputs = Stream.of("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab").collect(Collectors.toList());
        Map<String, Integer> result = new Day8Puzzle2().unscramble(inputs);

        assertEquals(expected, result);
    }

    @Test
    void testExamples() {
        assertEquals(5353, new Day8Puzzle2().solve("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf"));
    }
}
