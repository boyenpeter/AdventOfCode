package year2021.days.day5;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5Puzzle1 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day5Puzzle1().printSolution(); // 5698
    }

    @Override
    public Integer solve(BufferedReader br) {
        List<Line> lines = br.lines().map(Line::fromString).collect(Collectors.toList());

        // remove diagonals (for now)
        lines.removeIf(line -> line.fromX != line.toX && line.fromY != line.toY);

        int xMax = lines.stream().flatMapToInt(line -> IntStream.of(line.fromX, line.toX)).max().orElseThrow();
        int yMax = lines.stream().flatMapToInt(line -> IntStream.of(line.fromY, line.toY)).max().orElseThrow();

        int[][] field = new int[xMax + 1][yMax + 1];

        for(Line line : lines) {
            line.apply(field);
        }

        return (int) Arrays.stream(field)
                .flatMapToInt(Arrays::stream)
                .filter(i -> i >= 2)
                .count();
    }

    private static class Line {
        private final int fromX;
        private final int fromY;
        private final int toX;
        private final int toY;

        private Line(int fromX, int fromY, int toX, int toY) {
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }

        public static Line fromString(String string) {
            String[] splitString = string.split(" -> ");
            String[] splitFrom = splitString[0].split(",");
            String[] splitTo = splitString[1].split(",");

            return new Line(Integer.parseInt(splitFrom[0]), Integer.parseInt(splitFrom[1]),
                    Integer.parseInt(splitTo[0]), Integer.parseInt(splitTo[1]));
        }

        public void apply(int[][] field) {
            if(fromX == toX) {
                for(int y = Math.min(fromY, toY); y <= Math.max(fromY, toY); y++) {
                    field[fromX][y]++;
                }
            } else if(fromY == toY) {
                for(int x = Math.min(fromX, toX); x <= Math.max(fromX, toX); x++) {
                    field[x][fromY]++;
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }
}
