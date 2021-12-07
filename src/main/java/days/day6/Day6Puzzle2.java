package days.day6;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Day6Puzzle2 implements PuzzleSolver<Long> {
    public static void main(String[] args) {
        new Day6Puzzle2().printSolution(); // 1767323539209
    }

    @Override
    public Long solve(BufferedReader br) throws IOException {
        return simulate(br.readLine(), 256);
    }

    public long simulate(String input, int iterations) {
        long[] state = new long[9];
        Arrays.stream(input.split("\s*,\s*")).mapToInt(Integer::parseInt).forEach(i -> state[i]++);

        IntStream.rangeClosed(1, iterations).forEach(iteration -> iterate(state));

        return Arrays.stream(state).sum();
    }

    private void iterate(long[] state) {
        long newFishes = state[0];

        System.arraycopy(state, 1, state, 0, state.length - 1);

        state[6] += newFishes;
        state[8] = newFishes;

        System.out.println(Arrays.stream(state).sum());
    }
}
