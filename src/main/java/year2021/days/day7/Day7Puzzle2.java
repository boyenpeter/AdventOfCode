package year2021.days.day7;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class Day7Puzzle2 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day7Puzzle2().printSolution(); // 99266250
    }

    @Override
    public Integer solve(BufferedReader br) throws IOException {
        List<Integer> positions = Arrays.stream(br.readLine().split("\s*,\s*")).map(Integer::parseInt).toList();

        IntSummaryStatistics s = positions.stream().mapToInt(i -> i).summaryStatistics();

        return IntStream.rangeClosed(s.getMin(), s.getMax())
                .map(position -> getExpendedFuel(positions, position))
                .min().orElseThrow();
    }

    public int getExpendedFuel(List<Integer> positions, int position) {
        return positions.stream().mapToInt(p -> {
            int dist = Math.abs(p - position);
            return dist * (dist + 1) / 2;
        }).sum();
    }
}
