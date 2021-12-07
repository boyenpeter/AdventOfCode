package days.day2;

import util.PuzzleSolver;

import java.io.BufferedReader;

public class Day2Puzzle1 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day2Puzzle1().printSolution(); // 2039912
    }

    @Override
    public Integer solve(BufferedReader br) {
        int horizontal = 0;
        int vertical = 0;

        for(String line : br.lines().toList()) {
            String[] splitLine = line.split("\s+");
            assert splitLine.length == 2;

            String direction = splitLine[0];
            int distance = Integer.parseInt(splitLine[1]);

            if("forward".equals(direction)) {
                horizontal += distance;
            } else if("down".equals(direction)) {
                vertical += distance;
            } else if("up".equals(direction)) {
                vertical -= distance;
            } else {
                assert false : direction;
            }

            assert vertical >= 0;
        }

        return horizontal * vertical;
    }
}
