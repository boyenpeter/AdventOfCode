package days.day1;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.IntStream;

public class Day1Puzzle1 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day1Puzzle1().printSolution(); // 1521
    }

    @Override
    public Integer solve(BufferedReader br) {
        List<Integer> depths = br.lines().map(Integer::parseInt).toList();

        return (int) IntStream.range(1, depths.size())
                .filter(i -> depths.get(i - 1) < depths.get(i))
                .count();
    }
}
