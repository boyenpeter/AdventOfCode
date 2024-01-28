package year2023.day2;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.List;
import java.util.Map;

public class Day2Puzzle1 implements PuzzleSolver<Integer> {
    private static final Map<String, Integer> COLOR_TO_NUMBER_MAP = Map.of(
            "red", 12,
            "green", 13,
            "blue", 14
    );

    public static void main(String[] args) {
        new Day2Puzzle1().printSolution(); // 2545
    }

    @Override
    public Integer solve(BufferedReader br) {
        int result = 0;

        for(String line : br.lines().toList()) {
            String[] parts = line.split(": ");
            int gameNumber = Integer.parseInt(parts[0].substring("Game ".length()));

            if(isPossible(parts[1])) {
                result += gameNumber;
            }
        }

        return result;
    }

    private boolean isPossible(String part) {
        String[] singleColor = part.split("[,;] ");

        for(String color : singleColor) {
            String[] c = color.split(" ");

            if(Integer.parseInt(c[0]) > COLOR_TO_NUMBER_MAP.get(c[1])) {
                return false;
            }
        }

        return true;
    }
}
