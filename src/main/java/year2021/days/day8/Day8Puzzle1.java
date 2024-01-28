package year2021.days.day8;

import com.google.common.collect.ImmutableSet;
import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Set;

public class Day8Puzzle1 implements PuzzleSolver<Integer> {
    // The amount of segments in 1, 4, 7 and 8, respectively
    private static final Set<Integer> UNIQUE_LENGTHS = ImmutableSet.of(2, 4, 3, 7);

    public static void main(String[] args) {
        new Day8Puzzle1().printSolution(); // 274
    }

    @Override
    public Integer solve(BufferedReader br) {
        return (int) br.lines()
                .flatMap(line -> Arrays.stream(line.split("\s*\\|\s*")[1].split("\s+")))
                .filter(segment -> UNIQUE_LENGTHS.contains(segment.length()))
                .count();
    }
}
