import java.util.Objects;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamUtils {
    public static <T> Stream<T> unfold(T seed, UnaryOperator<T> f) {
        return Stream.iterate(seed, Objects::nonNull, f);
    }
}