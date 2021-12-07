package days.day1;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.IntStream;

public class Day1Puzzle2 implements PuzzleSolver<Integer> {
    private static final int WINDOW_SIZE = 3;

    public static void main(String[] args) {
        new Day1Puzzle2().printSolution(); // 1543
    }

    @Override
    public Integer solve(BufferedReader br) {
        List<Integer> depths = br.lines().map(Integer::parseInt).toList();

        return (int) IntStream.range(WINDOW_SIZE, depths.size())
                .filter(i -> depths.get(i - WINDOW_SIZE) < depths.get(i))
                .count();
    }
}
