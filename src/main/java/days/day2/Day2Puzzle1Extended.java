package days.day2;

import com.google.common.collect.ImmutableMap;
import util.PuzzleSolver;

import java.io.BufferedReader;
import java.util.Map;

public class Day2Puzzle1Extended implements PuzzleSolver<Integer> {
    public static void main(String[] args) {
        new Day2Puzzle1Extended().printSolution(); // 2039912
    }

    private static class SubmarineState {
        private int horizontal;
        private int vertical; // note that this expresses depth

        public SubmarineState() {
            horizontal = 0;
            vertical = 0;
        }

        public int getHorizontal() {
            return horizontal;
        }

        public void setHorizontal(int horizontal) {
            this.horizontal = horizontal;
        }

        public int getVertical() {
            return vertical;
        }

        public void setVertical(int vertical) {
            this.vertical = vertical;
        }

        public void apply(Command command) {
            command.apply(this);
        }
    }

    private enum CommandDirection {
        FORWARD("forward"),
        DOWN("down"),
        UP("up");

        private static final Map<String, CommandDirection> TEXT_REPRESENTATION_MAP;
        static {
            ImmutableMap.Builder<String, CommandDirection> builder = ImmutableMap.builder();
            for(CommandDirection direction : values()) {
                builder.put(direction.textRepresentation, direction);
            }
            TEXT_REPRESENTATION_MAP = builder.build();
        }

        private final String textRepresentation;

        CommandDirection(String textRepresentation) {
            this.textRepresentation = textRepresentation;
        }

        public static CommandDirection fromString(String string) {
            return TEXT_REPRESENTATION_MAP.get(string);
        }

        public void apply(SubmarineState state, int distance) {
            switch(this) {
                case FORWARD -> state.setHorizontal(state.getHorizontal() + distance);
                case DOWN -> state.setVertical(state.getVertical() + distance);
                case UP -> state.setVertical(state.getVertical() - distance);
            }
        }
    }

    private static class Command {
        private final CommandDirection direction;
        private final int distance;

        public Command(CommandDirection direction, int distance) {
            this.direction = direction;
            this.distance = distance;
        }

        public static Command fromString(String line) {
            String[] splitLine = line.split(" ");
            assert splitLine.length == 2;

            return new Command(CommandDirection.fromString(splitLine[0]), Integer.parseInt(splitLine[1]));
        }

        public void apply(SubmarineState state) {
            direction.apply(state, distance);
        }
    }

    @Override
    public Integer solve(BufferedReader br) {
        SubmarineState state = new SubmarineState();

        br.lines().map(Command::fromString).forEach(state::apply);

        return state.getHorizontal() * state.getVertical();
    }
}
