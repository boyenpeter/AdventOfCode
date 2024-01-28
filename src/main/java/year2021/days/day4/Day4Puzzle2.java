package year2021.days.day4;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day4Puzzle2 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day4Puzzle2().printSolution(); // 4880
    }

    @Override
    public Integer solve(BufferedReader br) throws IOException {
        List<Integer> values = Arrays.stream(br.readLine().split(","))
                .map(Integer::parseInt)
                .toList();

        List<Board> boards = new ArrayList<>();

        while(br.readLine() != null) {
            boards.add(readBoard(br));
        }

        for(Integer value : values) {
            Iterator<Board> it = boards.iterator();

            while(it.hasNext()) {
                Board board = it.next();
                Integer score = board.markBoard(value);

                if(score != null) {
                    if(boards.size() == 1) {
                        return score;
                    } else {
                        it.remove();
                    }
                }
            }
        }

        return null;
    }

    private Board readBoard(BufferedReader br) throws IOException {
        List<List<Integer>> board = new ArrayList<>(5);

        for(int i = 0; i < 5; i++) {
            board.add(Arrays.stream(br.readLine().trim().split("\s+")).map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }

        return new Board(board);
    }

    private static class Board {
        private final List<List<Integer>> board;

        private Board(List<List<Integer>> board) {
            this.board = board;
        }

        /**
         * Returns the score if finished, null otherwise
         */
        public Integer markBoard(Integer value) {
            for(int row = 0; row < 5; row++) {
                for(int column = 0; column < 5; column++) {
                    if(Objects.equals(board.get(row).get(column), value)) {
                        board.get(row).set(column, null);

                        if(isFinished(row, column)) {
                            return getScore(value);
                        }

                        return null;
                    }
                }
            }

            return null;
        }

        private boolean isFinished(int row, int column) {
            return isRowFinished(row) || isColumnFinished(column);
        }

        private boolean isRowFinished(int row) {
            return board.get(row).stream()
                    .allMatch(Objects::isNull);
        }

        private boolean isColumnFinished(int column) {
            return IntStream.range(0, 5)
                    .mapToObj(row -> board.get(row).get(column))
                    .allMatch(Objects::isNull);
        }

        private int getScore(int value) {
            return value * board.stream()
                    .flatMap(Collection::stream)
                    .filter(Objects::nonNull)
                    .mapToInt(i -> i)
                    .sum();
        }
    }
}
