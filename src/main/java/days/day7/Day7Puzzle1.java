package days.day7;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class Day7Puzzle1 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day7Puzzle1().printSolution(); // 352331
    }

    @Override
    public Integer solve(BufferedReader br) throws IOException {
        List<Integer> positions = Arrays.stream(br.readLine().split("\s*,\s*")).map(Integer::parseInt).toList();

        IntSummaryStatistics s = positions.stream().mapToInt(i -> i).summaryStatistics();

        return IntStream.rangeClosed(s.getMin(), s.getMax())
                .map(position -> positions.stream().mapToInt(p -> Math.abs(p - position)).sum())
                .min().orElseThrow();
    }
}
