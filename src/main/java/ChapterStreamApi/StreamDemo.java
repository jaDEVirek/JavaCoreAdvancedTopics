package ChapterStreamApi;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        Stream<Integer> integerStream= Stream.iterate(1, n -> ++n);
        System.out.println(Arrays.toString(integerStream.limit(5)
                .toArray()));
    }
}
