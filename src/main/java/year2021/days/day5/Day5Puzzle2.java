package year2021.days.day5;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5Puzzle2 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day5Puzzle2().printSolution(); // 15463
    }

    @Override
    public Integer solve(BufferedReader br) {
        List<Line> lines = br.lines().map(Line::fromString).collect(Collectors.toList());

        int xMax = lines.stream().flatMapToInt(line -> IntStream.of(line.fromX, line.toX)).max().orElseThrow();
        int yMax = lines.stream().flatMapToInt(line -> IntStream.of(line.fromY, line.toY)).max().orElseThrow();

        int[][] field = new int[xMax + 1][yMax + 1];

        for(Line line : lines) {
            line.forEachCoordinate((x, y) -> field[x][y]++);
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

        private final int distance;
        private final int xStep;
        private final int yStep;

        private Line(int fromX, int fromY, int toX, int toY) {
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;

            int xDistance = 0;
            int xStep = 0;
            int yDistance = 0;
            int yStep = 0;

            if(fromX != toX) {
                int xDiff = toX - fromX;
                xDistance = Math.abs(xDiff);
                xStep = xDiff / xDistance;
            }

            if(fromY != toY) {
                int yDiff = toY - fromY;
                yDistance = Math.abs(yDiff);
                yStep = yDiff / yDistance;
            }

            assert xDistance == 0 || yDistance == 0 || xDistance == yDistance : xDistance + " != " + yDistance;

            this.distance = Math.max(xDistance, yDistance);
            this.xStep = xStep;
            this.yStep = yStep;
        }

        public static Line fromString(String string) {
            List<Integer> indexes = Arrays.stream(string.trim().split("\s*->\s*|\s*,\s*"))
                    .map(Integer::parseInt).toList();

            return new Line(indexes.get(0), indexes.get(1), indexes.get(2), indexes.get(3));
        }

        public void forEachCoordinate(BiConsumer<Integer, Integer> coordinateConsumer) {
            for(int i = 0; i <= distance; i++) {
                coordinateConsumer.accept(fromX + i * xStep, fromY + i * yStep);
            }
        }
    }
}
