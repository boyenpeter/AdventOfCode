package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public interface PuzzleSolver<T> {
    /**
     * Solves the puzzle and prints the solution to standard output.
     */
    default void printSolution() {
        T solution = readFileAndSolve("input.txt");

        System.out.println(solution);
    };

    /**
     * Reads in the input file and solves the puzzle. Returns the solution.
     */
    default T readFileAndSolve(String filename) {
        InputStream inputStream = getClass().getResourceAsStream(filename);

        if (inputStream == null) {
            throw new IllegalStateException("Input file not found");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            return solve(br);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    T solve(BufferedReader br) throws IOException;
}
