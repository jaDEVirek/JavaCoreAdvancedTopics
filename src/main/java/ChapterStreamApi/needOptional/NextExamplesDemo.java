package ChapterStreamApi.needOptional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class NextExamplesDemo {

    public static void main(String[] args) {
        Optional<BigDecimal> first = Optional.of(new BigDecimal(1));
        Optional<BigDecimal> two = Optional.of(new BigDecimal(2));

        Optional<Optional<BigDecimal>> bigDecimal = first.map(f -> two.map(f::add) // too nested and complex
                .orElse(f))
                .map(Optional::of);
        Optional<BigDecimal> bigDecimal1 = bigDecimal.orElse(two);
        //problem with optional - get() ! We should avoid to use get.
        // second do not use Optional as parameter
        // myMethod(Optional.of("value"));
        // AVOID OPTIONAL IN COLLECTION - > made problems with sort for example
    }

    // nested optional in list
    public static void  badExample(List<Optional<Integer>> optionalList){
        Stream<Optional<Integer>> sorted = optionalList.stream()
                .sorted();
        Optional<Integer> other = sorted.findFirst()
                .orElse(Optional.of(2));

        Integer reduce = sorted.flatMap(Optional::stream)
                .reduce(Integer::sum).orElse(0);

        Optional<Integer> reduce1 = Stream.of(reduce)
                .map(Optional::of)    // Stream<Optional<Integer>>
                .filter(Optional::isPresent) // Stream<Optional<Integer>>
                .map(Optional::get)// Stream<Integer>
                .reduce(Integer::sum);// Option<Integer>
    }

}
