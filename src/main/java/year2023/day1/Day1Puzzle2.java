package year2023.day1;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.Map;

public class Day1Puzzle2 implements PuzzleSolver<Integer> {
    private static final Map<String, Integer> WORD_TO_NUMBER_MAP = Map.of(
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
            );

    public static void main(String[] args) {
        new Day1Puzzle2().printSolution(); // 55260
    }

    @Override
    public Integer solve(BufferedReader br) {
        return br.lines().mapToInt(this::getCalibrationValue).sum();
    }

    private int getCalibrationValue(String line) {
        int firstDigit = 0;
        int lastDigit = 0;

        for(int i = 0; i < line.length(); i++) {
            Integer digit = getDigit(line, i);

            if(digit != null) {
                firstDigit = digit;
                break;
            }
        }

        for(int i = line.length() -1; i >= 0; i--) {
            Integer digit = getDigit(line, i);

            if(digit != null) {
                lastDigit = digit;
                break;
            }
        }

        return firstDigit * 10 + lastDigit;
    }

    private Integer getDigit(String line, int index) {
        if(line.charAt(index) >= '0' && line.charAt(index) <= '9') {
            return line.charAt(index) - '0';
        }

        for(Map.Entry<String, Integer> entry : WORD_TO_NUMBER_MAP.entrySet()) {
            if(line.substring(index).startsWith(entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }
}
