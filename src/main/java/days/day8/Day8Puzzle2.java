package days.day8;

import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day8Puzzle2 implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day8Puzzle2().printSolution(); // 1012089
    }

    @Override
    public Integer solve(BufferedReader br) {
        return br.lines().mapToInt(this::solve).sum();
    }

    public int solve(String string) {
        String[] splitString = string.trim().split("\s*\\|\s*");

        Map<String, Integer> mapping = unscramble(Arrays.stream(splitString[0].split("\s+")).collect(Collectors.toList()));

        return Arrays.stream(splitString[1].split("\s+"))
                .map(Day8Puzzle2::canonical)
                .map(mapping::get)
                .reduce(0, (i1, i2) -> i1 * 10 + i2);
    }

    public Map<String, Integer> unscramble(List<String> inputs) {
        assert inputs.size() == 10;

        inputs.sort(Comparator.comparing(String::length));

        Map<String, Integer> result = new HashMap<>();

        // First, we identify those with unique lengths
        // 2:be (1)
        String one = inputs.remove(0);
        assert one.length() == 2;
        result.put(canonical(one), 1);

        // 3:edb (7)
        String seven = inputs.remove(0);
        assert seven.length() == 3;
        result.put(canonical(seven), 7);

        // 4:cgeb (4)
        String four = inputs.remove(0);
        assert four.length() == 4;
        result.put(canonical(four), 4);

        // 7:cfbegad (8)
        String eight = inputs.remove(inputs.size() - 1);
        assert eight.length() == 7;
        result.put(canonical(eight), 8);

        // For the remaining lengths (5 and 6) we look for defining characteristics
        // 6:cbdgef fgaecd agebfd (0, 6, and 9)
        // 9 contains everything in 4
        List<String> nine = inputs.stream().filter(i -> i.length() == 6 && containsAll(i, four)).collect(Collectors.toList());
        assert nine.size() == 1;
        inputs.remove(nine.get(0));
        result.put(canonical(nine.get(0)), 9);

        // 0 contains eveything in 7
        List<String> zero = inputs.stream().filter(i -> i.length() == 6 && containsAll(i, seven)).collect(Collectors.toList());
        assert zero.size() == 1;
        inputs.remove(zero.get(0));
        result.put(canonical(zero.get(0)), 0);

        // 6 is the only remaining with 6 characters
        List<String> six = inputs.stream().filter(i -> i.length() == 6).collect(Collectors.toList());
        assert six.size() == 1;
        inputs.remove(six.get(0));
        result.put(canonical(six.get(0)), 6);

        // 5:fdcge fecdb fabcd (2, 3, and 5)
        // 3 contains everything in 7
        List<String> three = inputs.stream().filter(i -> containsAll(i, seven)).collect(Collectors.toList());
        assert three.size() == 1;
        inputs.remove(three.get(0));
        result.put(canonical(three.get(0)), 3);

        // 5 is contained in 6
        List<String> five = inputs.stream().filter(i -> containsAll(six.get(0), i)).collect(Collectors.toList());
        assert five.size() == 1;
        inputs.remove(five.get(0));
        result.put(canonical(five.get(0)), 5);

        // 2 is what remains
        result.put(canonical(inputs.remove(0)), 2);

        assert result.size() == 10;
        return result;
    }

    public static boolean containsAll(String string, String letters) {
        return letters.chars().mapToObj(i -> "" + (char) i).allMatch(string::contains);
    }

    public static String canonical(String s) {
        return s.chars().sorted().mapToObj(i -> "" + (char) i).collect(Collectors.joining());
    }
}
