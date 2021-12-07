package days.day2;

import util.PuzzleSolver;

import java.io.BufferedReader;

public class Day2Puzzle2 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day2Puzzle2().printSolution(); // 1942068080
    }

    @Override
    public Integer solve(BufferedReader br) {
        int horizontal = 0;
        int vertical = 0;
        int aim = 0;

        for(String line : br.lines().toList()) {
            String[] splitLine = line.split(" ");
            assert splitLine.length == 2;

            String direction = splitLine[0];
            int distance = Integer.parseInt(splitLine[1]);

            if("forward".equals(direction)) {
                horizontal += distance;
                vertical += distance * aim;
            } else if("down".equals(direction)) {
                aim += distance;
            } else if("up".equals(direction)) {
                aim -= distance;
            } else {
                assert false : direction;
            }

            assert vertical >= 0;
        }

        return horizontal * vertical;
    }
}
