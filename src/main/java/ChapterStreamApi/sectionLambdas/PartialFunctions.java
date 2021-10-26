package ChapterStreamApi.sectionLambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PartialFunctions {


    public static void main(String[] args) {

            BiFunction<Integer,Integer,Integer> biF = (x,y)-> (x % y);
        final Integer apply =
                partial(biF, 11).apply(2);
        System.out.println(apply);

    }

    public static <T, U, R> Function<U, R> partial(BiFunction<T, U, R> f, T x) {
        return (y) -> f.apply(x, y);
    }

    
}


@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T a, U b, V c);
}
