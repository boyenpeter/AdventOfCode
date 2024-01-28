package year2023.day2;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class Day2Puzzle2 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day2Puzzle2().printSolution(); // 78111
    }

    @Override
    public Integer solve(BufferedReader br) {
        return br.lines().mapToInt(this::getPower).sum();
    }

    private int getPower(String line) {
        Map<String, Integer> minima = new HashMap<>();
        minima.put("red", 0);
        minima.put("green", 0);
        minima.put("blue", 0);

        String[] parts = line.split(": ")[1].split("[,;] ");

        for(String part : parts) {
            String[] c = part.split(" ");
            int amount = Integer.parseInt(c[0]);
            String color = c[1];

            minima.put(color, Math.max(minima.get(color), amount));
        }

        return minima.get("red") * minima.get("green") * minima.get("blue");
    }
}
