package util;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class Pair<F, S> {
    private final F first;
    private final S second;

    public Pair(@NonNull F first, @NonNull S second) {
        this.first = Preconditions.checkNotNull(first);
        this.second = Preconditions.checkNotNull(second);
    }

    public @NonNull F getFirst() {
        return first;
    }

    public @NonNull S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Pair<?, ?> otherPair = (Pair<?, ?>) other;
        return Objects.equal(first, otherPair.first) && Objects.equal(second, otherPair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(first, second);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ')';
    }
}
