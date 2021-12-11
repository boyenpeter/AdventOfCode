package days.day9;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Day9Puzzle2 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day9Puzzle2().printSolution(); // 1198704
    }

    @Override
    public Integer solve(BufferedReader br) {
        List<List<Integer>> heightMap = br.lines().map(line -> line.chars().mapToObj(c -> c - '0').toList()).toList();

        List<Integer> basinSizes = new LinkedList<>();

        for(int row = 0; row < heightMap.size(); row++) {
            for (int column = 0; column < heightMap.get(0).size(); column++) {
                if(isLowPoint(heightMap, row, column)) {
                    basinSizes.add(getBasinSize(heightMap, row, column, new boolean[heightMap.size()][heightMap.get(0).size()]));
                }
            }
        }

        basinSizes.sort(Comparator.<Integer>naturalOrder().reversed());

        return basinSizes.get(0) * basinSizes.get(1) * basinSizes.get(2);
    }

    private Integer getBasinSize(List<List<Integer>> heightMap, int row, int column, boolean[][] visited) {
        if(row < 0 || column < 0 || row >= heightMap.size() || column >= heightMap.get(0).size()) {
            return 0;
        }
        if(heightMap.get(row).get(column) == 9) {
            return 0;
        }
        if(visited[row][column]) {
            return 0;
        }

        visited[row][column] = true;

        return 1
                + getBasinSize(heightMap, row - 1, column, visited)
                + getBasinSize(heightMap, row + 1, column, visited)
                + getBasinSize(heightMap, row, column - 1, visited)
                + getBasinSize(heightMap, row, column + 1, visited);
    }


    private boolean isLowPoint(List<List<Integer>> heightMap, int row, int column) {
        return neighbourValues(heightMap, row, column).allMatch(v -> v > heightMap.get(row).get(column));
    }

    private Stream<Integer> neighbourValues(List<List<Integer>> heightMap, int row, int column) {
        List<Integer> result = new ArrayList<>(4);

        if(row - 1 >= 0) {
            result.add(heightMap.get(row - 1).get(column));
        }
        if(row + 1 < heightMap.size()) {
            result.add(heightMap.get(row + 1).get(column));
        }
        if(column - 1 >= 0) {
            result.add(heightMap.get(row).get(column - 1));
        }
        if(column + 1 < heightMap.get(0).size()) {
            result.add(heightMap.get(row).get(column + 1));
        }

        return result.stream();
    }
}
