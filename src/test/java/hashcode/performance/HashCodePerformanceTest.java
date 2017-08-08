package hashcode.performance;

import hashcode.EqualsObject;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HashCodePerformanceTest {

    public static final int OCCURENCES = 10000;

    @Test
    public void slow_hashcode_worst_scenario() {
        Stream<SlowHashCode> stream = IntStream.range(0, OCCURENCES)
                .mapToObj(i -> new SlowHashCode("code", i + ""));

        System.out.print("Slow hashcode in worst case - same perf as constant hashcode: ");
        measure(stream);
    }

    @Test
    public void slow_hashcode_best_scenario() {
        Stream<SlowHashCode> stream = IntStream.range(0, OCCURENCES)
                .mapToObj(i -> new SlowHashCode(i + "", i + ""));

        System.out.print("Slow hashcode in best case - code is unique in the dataset: ");
        measure(stream);
    }

    @Test
    public void veryslow() {
        Stream<VerySlowHashcode> stream = IntStream.range(0, OCCURENCES)
                .mapToObj(i -> new VerySlowHashcode("code", i + ""));

        System.out.print("Constant hashcode is very slow in any case: ");
        measure(stream);
    }

    @Test
    public void fast() {
        Stream<FastHashCode> stream = IntStream.range(0, OCCURENCES)
                .mapToObj(i -> new FastHashCode("code", i + ""));

        System.out.print("Best hashcode: ");
        measure(stream);
    }

    private void measure(Stream<? extends EqualsObject> stream) {
        long before = System.currentTimeMillis();

        stream.collect(Collectors.toSet());

        long after = System.currentTimeMillis();
        long duration = after - before;
        System.out.println(duration);
    }

}