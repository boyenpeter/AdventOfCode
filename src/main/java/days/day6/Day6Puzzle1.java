package days.day6;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Day6Puzzle1 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day6Puzzle1().printSolution(); // 395627
    }

    @Override
    public Integer solve(BufferedReader br) throws IOException {
        return simulate(br.readLine(), 80);
    }

    public int simulate(String input, int iterations) {
        int[] state = new int[9];
        Arrays.stream(input.split("\s*,\s*")).mapToInt(Integer::parseInt).forEach(i -> state[i]++);

        IntStream.rangeClosed(1, iterations).forEach(iteration -> iterate(state));

        return Arrays.stream(state).sum();
    }

    private void iterate(int[] state) {
        int newFishes = state[0];

        System.arraycopy(state, 1, state, 0, state.length - 1);

        state[6] += newFishes;
        state[8] = newFishes;
    }
}
