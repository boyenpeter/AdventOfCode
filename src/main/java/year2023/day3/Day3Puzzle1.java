package year2023.day3;

import util.Arrays2d;
import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;

public class Day3Puzzle1 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day3Puzzle1().printSolution(); // 546563
    }

    @Override
    public Integer solve(BufferedReader br) {
        char[][] grid = br.lines().map(String::toCharArray).toArray(char[][]::new);

        boolean[][] safe = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < safe.length; i++) {
            for(int j = 0; j < safe[0].length; j++) {
                safe[i][j] |= isSymbol(grid[i][j]);
            }
        }

        // TODO I think this is actually too lenient, but it works in this case
        // E.g. I should not have allowed numbers to make numbers on a higher line safe
        boolean change = true;
        while(change) {
            change = false;

            for(int i = 0; i < safe.length; i++) {
                for(int j = 0; j < safe[0].length; j++) {
                    if(!safe[i][j] && Character.isDigit(grid[i][j])) {
                        for(int k = -1; k <= 1; k++) {
                            for(int l = -1; l <= 1; l++) {
                                if(i + k >= 0 && i + k < safe.length && j + l >= 0 && j + l < safe[0].length) {
                                    safe[i][j] |= safe[i + k][j + l];
                                }
                            }
                        }

                        change |= safe[i][j];
                    }
                }
            }
        }

        for(int i = 0; i < safe.length; i++) {
            for(int j = 0; j < safe[0].length; j++) {
                if(!safe[i][j] || !Character.isDigit(grid[i][j])) {
                    grid[i][j] = '.';
                }
            }
        }

        int result = 0;

        for(int i = 0; i < grid.length; i++) {
            String s = new String(grid[i]);

            for(String part : s.split("\\.")) {
                if(part.length() > 0) {
                    result += Integer.parseInt(part);
                }
            }
        }

        return result;
    }

    private boolean isSymbol(char c) {
        return !Character.isDigit(c) && c != '.';
    }
}
