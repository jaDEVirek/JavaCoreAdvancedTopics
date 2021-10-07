package ChapterStreamApi.needOptional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMapDemos {

    public static void main(String[] args) {
        Optional<Optional<String>> s1 = Optional
                .of("string")
                .map(s -> Optional.of("STRING"));

        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(myList);
        Optional<Integer> integerStream = Stream.of("a", "b")
                .map(String::length).reduce(Integer::sum);
        integerStream.ifPresent(System.out::println);
    }
}
