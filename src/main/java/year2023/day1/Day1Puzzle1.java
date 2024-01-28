package year2023.day1;

import util.PuzzleSolver;

import java.io.BufferedReader;

public class Day1Puzzle1 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day1Puzzle1().printSolution(); // 55123
    }

    @Override
    public Integer solve(BufferedReader br) {
        return br.lines().mapToInt(this::getCalibrationValue).sum();
    }

    private int getCalibrationValue(String line) {
        line = line.replaceAll("[\\D]+", "");
        line = "" + line.charAt(0) + line.charAt(line.length() - 1);

        return Integer.parseInt(line);
    }
}
