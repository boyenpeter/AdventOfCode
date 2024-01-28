package year2021.days.day3;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.List;

public class Day3Puzzle1 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day3Puzzle1().printSolution(); // 4147524
    }

    @Override
    public Integer solve(BufferedReader br) {
        List<String> lines = br.lines().toList();
        int halfOfLines = lines.size() / 2;

        int[] ones = new int[lines.get(0).length()];
        for(String line : lines) {
            assert line.length() == ones.length;

            for(int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == '1') {
                    ones[i]++;
                } else {
                    assert line.charAt(i) == '0';
                }
            }
        }

        StringBuilder gammaString = new StringBuilder();
        StringBuilder epsilonString = new StringBuilder();

        for(int i : ones) {
            assert i != halfOfLines;

            gammaString.append(i > halfOfLines ? '1' : '0');
            epsilonString.append(i > halfOfLines ? '0' : '1');
        }

        int gammaRate = Integer.parseInt(gammaString.toString(), 2);
        int epsilonRate = Integer.parseInt(epsilonString.toString(), 2);

        return gammaRate * epsilonRate;
    }
}
