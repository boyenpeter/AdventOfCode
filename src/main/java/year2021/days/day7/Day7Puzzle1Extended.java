package year2021.days.day7;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day7Puzzle1Extended implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day7Puzzle1Extended().printSolution(); // 352331

        System.out.println(new Day7Puzzle1Extended().solve(new ArrayList<>(List.of(1, 1, 1, 10, 50, 100, 1000, 10000))));
    }

    @Override
    public Integer solve(BufferedReader br) throws IOException {
        List<Integer> positions = Arrays.stream(br.readLine().split("\s*,\s*")).map(Integer::parseInt).collect(Collectors.toList());

        return solve(positions);
    }

    public int solve(List<Integer> positions) {
        positions.sort(Comparator.naturalOrder());

        // In 1 dimension, the median minimizes the sum of distances
        int bestPos = positions.get(positions.size() / 2);

        return positions.stream().mapToInt(p -> Math.abs(p - bestPos)).sum();
    }
}
