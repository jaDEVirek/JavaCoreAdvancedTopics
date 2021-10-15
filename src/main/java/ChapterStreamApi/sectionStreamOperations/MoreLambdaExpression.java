package ChapterStreamApi.sectionStreamOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class MoreLambdaExpression {

    public static void main(String[] args) {
        // 1. Integer Stream
        IntStream
                .range(1, 10)
                .forEach(System.out::print);
        System.out.println();
        // 2. Integer Stream with skip
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(System.out::println);
        System.out.println();
        // 3. Integer Stream with sum
        System.out.println(
                IntStream
                        .range(1, 5)
                        .sum());
        System.out.println();

        lambdaConsumers();
    }


    public static void lambdaConsumers(){
        Consumer<String> consumer  =  (String t ) -> {
            System.out.println(t.length());
        };
        consumer.accept("Lentirtios ");
        Consumer<List<String>> clearConsumer = null;
        List<String> strings = new ArrayList<>(Arrays.asList("a", "b", "c"));
        try {
            clearConsumer.accept(strings); // null pointer exception

        }catch (NullPointerException ignored){
        }finally {
            //take a look no differenceclearList
            System.out.println("Array " + strings);
            clearConsumer = List::clear;
            clearConsumer.accept(strings);
            System.out.println("Array " + (strings.isEmpty() ? strings : "NOT Empty") );
        }

        Consumer<List<String>>  listConsum1 = t->t.add("One");
        Consumer<List<String>>  listConsum2 = t->t.add("Two");
        Consumer<List<String>> twoAddConsumer =  listConsum1.andThen(listConsum2);
        strings.add("New");
        twoAddConsumer.accept(strings);
        System.out.println(strings);

    }

}
