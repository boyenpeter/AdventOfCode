package year2021.days.day3;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Day3Puzzle2 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day3Puzzle2().printSolution(); // 3570354
    }

    @Override
    public Integer solve(BufferedReader br) {
        List<String> oxygenLines = new ArrayList<>(br.lines().toList());
        List<String> co2Lines = new ArrayList<>(oxygenLines);

        int oxygenRating = getRating(oxygenLines, this::determineMostCommonCharacter);
        int co2Rating = getRating(co2Lines, this::determineLeastCommonCharacter);

        return oxygenRating * co2Rating;
    }

    private int getRating(List<String> lines, BiFunction<List<String>, Integer, Character> desiredCharacterFunction) {
        int index = 0;

        while(lines.size() != 1) {
            char desiredCharacter = desiredCharacterFunction.apply(lines, index);

            final int fIndex = index;
            lines.removeIf(line -> line.charAt(fIndex) != desiredCharacter);

            index++;
        }

        return Integer.parseInt(lines.get(0), 2);
    }

    private char determineMostCommonCharacter(List<String> lines, int index) {
        long ones = lines.stream().filter(l -> l.charAt(index) == '1').count();
        return ones >= lines.size() / 2.0 ? '1' : '0';
    }

    private char determineLeastCommonCharacter(List<String> lines, int index) {
        return determineMostCommonCharacter(lines, index) == '1' ? '0' : '1';
    }
}
