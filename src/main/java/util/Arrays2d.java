package util;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Arrays2d {
    /**
     * Given a 2d array, returns a Stream of the coordinates in that array (as Pairs).
     *
     * If the array has a length of 0 or each of its rows has a width of 0, an empty Stream is returned.
     *
     * @param field rectangular 2d array
     * @return a Stream of the coordinates in that array
     */
    public static @NonNull Stream<Pair<Integer, Integer>> coordinates(@NonNull int[][] field) {
        AtomicInteger row = new AtomicInteger(0);
        AtomicInteger column = new AtomicInteger(-1);

        // TODO define proper characteristics
        return StreamSupport.stream(new Spliterators.AbstractSpliterator<>(Long.MAX_VALUE, Spliterator.DISTINCT) {
            @Override
            public boolean tryAdvance(Consumer<? super Pair<Integer, Integer>> action) {
                while(row.get() < field.length && column.incrementAndGet() >= field[row.get()].length) {
                    row.incrementAndGet();
                    column.set(0);
                }

                if(row.get() < field.length) {
                    action.accept(new Pair<>(row.get(), column.get()));
                    return true;
                } else {
                    return false;
                }
            }
        }, false);
    }

    public static void main(String[] args) {
        coordinates(new int[3][10]).forEach(System.out::println);
    }
}
