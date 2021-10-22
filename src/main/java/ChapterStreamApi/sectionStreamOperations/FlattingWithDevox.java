package ChapterStreamApi.sectionStreamOperations;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static ChapterStreamApi.sectionStreamOperations.AlphabetSonnetExample.*;
import static java.util.stream.Collectors.toList;

public class FlattingWithDevox {

    public static void main(String[] args) {
//        runWIthGivenWords();
        splitSonnet();
        reductorExample();
        exerciseOfUnaryOperator();
    }

    public static void runWIthGivenWords() {
        final List<List<String>> collect = getAlphabet()
                .stream()
                .map(word -> List.of(word.split("")))
                .collect(toList());
        System.out.println(collect);
        //flat
        final List<String> collect1 = collect.stream()
                .flatMap(Collection::stream)
                .collect(toList());
        System.out.println(collect1);

        //with expand
        final List<String> collect2 = getAlphabet()
                .stream()
                .flatMap(word -> expandStr(word)
                        .stream())
                .collect(toList());
    }

    public static void splitSonnet() {
        final List<String> collect = getSonnet().stream()
                .flatMap(word -> List.of(word.replaceAll("[,:]", "")
                        .split(" +"))
                        .stream())
                .collect(toList());
        System.out.println("Sonnet:");
        System.out.println(collect);
        final long count = collect.stream()
                .count();
        System.out.println(count);
    }

    public static void reductorExample() {
        final BigDecimal reduce = IntStream.rangeClosed(1, 21)
                .mapToObj(BigDecimal::new)
                .reduce(BigDecimal.ONE, BigDecimal::multiply);
        System.out.println(reduce);
    }

    public static void filtering(){
        final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Predicate<String> gotNumb = x -> pattern.matcher(x).matches();
        Predicate<String> gotSpace = x -> x.contains(" ");

        final List<String> collect = getAlphabet().stream()
                .filter(gotNumb.and(gotSpace))
                .collect(toList());
        System.out.println(collect);
    }

    public static void exerciseOfUnaryOperator(){
        final List<IntUnaryOperator> unaryOperator = List.of(i -> i + 1, i -> i + 3,i -> i * 2);
        final IntUnaryOperator combine = combine(unaryOperator);
        System.out.println(combine.applyAsInt(5));
    }

    static IntUnaryOperator combine(List<IntUnaryOperator> operators){
        return operators.stream()
                .reduce(IntUnaryOperator.identity(), IntUnaryOperator::andThen);
    }
}
