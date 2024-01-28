package year2023.day3;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Day3Puzzle2 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day3Puzzle2().printSolution(); // ???
    }

    @Override
    public Integer solve(BufferedReader br) {
        char[][] grid = br.lines().map(String::toCharArray).toArray(char[][]::new);

        int result = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '*') {
                    List<Integer> neighbours = getNumberNeighbours(grid, i, j);
                }
            }
        }

        return result;
    }

    private List<Integer> getNumberNeighbours(char[][] grid, int i, int j) {
        List<Integer> result = new ArrayList<>();



        return result;
    }

    private boolean isSymbol(char c) {
        return c == '*';
    }
}
