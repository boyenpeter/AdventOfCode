package year2021.days.day9;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day9Puzzle1 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day9Puzzle1().printSolution(); // 423
    }

    @Override
    public Integer solve(BufferedReader br) {
        List<List<Integer>> heightMap = br.lines().map(line -> line.chars().mapToObj(c -> c - '0').toList()).toList();

        int risk = 0;

        for(int row = 0; row < heightMap.size(); row++) {
            for(int column = 0; column < heightMap.get(0).size(); column++) {
                if(isLowPoint(heightMap, row, column)) {
                    risk += heightMap.get(row).get(column) + 1;
                }
            }
        }

        return risk;
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
