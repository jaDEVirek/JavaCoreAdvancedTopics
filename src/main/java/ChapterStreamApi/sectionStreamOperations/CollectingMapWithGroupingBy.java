package ChapterStreamApi.sectionStreamOperations;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ChapterStreamApi.sectionStreamOperations.AlphabetSonnetExample.*;
import static java.util.stream.Collectors.*;

public class CollectingMapWithGroupingBy {

    public static void main(String[] args) {
//        groupByLength();
//        collectAndGroupSonet();
//        streamCountingCollectors();

//        generateFrequencyTable();
        System.out.println(expand("trello"));
        System.out.println(expandStr("trello"));
        // its importat that A is not same as a, so case of chararcter is important
//        countWordInSonetThenGetMax();
//        overTheIndexesInStream(4);
//        overlapbyIndexSubArrays(4);
        nonDecreasingSubList();

    }


    public static void groupByLength() {
        // writing own groupingByLength
        final Map<Integer, List<String>> collect1 = getAlphabet().stream()
                .collect(toMap(String::length, word -> new ArrayList<>(Collections.singletonList(word)),
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        }));

        final Map<Integer, List<String>> collect = getAlphabet().stream()
                .collect(groupingBy(String::length));
        System.out.println(collect.equals(collect1) + "Is true that:");
    }

    public static void collectAndGroupSonet() {
        final Map<String, Map<Integer, List<String>>> collect = getSonnet().stream()
                .collect(groupingBy(word -> word.substring(0, 1), groupingBy(String::length)));
        collect.forEach((k, v) ->
                System.out.println(k + " and " + v.entrySet()));
    }

    public static void streamCountingCollectors() {
        final Stream<String> elementsStream = getAlphabet().stream();
        final Stream<String> copyOFElem = elementsStream;
        final Map<String, Long> collect = elementsStream
                .collect(groupingBy(line -> line.substring(0, 1), Collectors.counting()));
        System.out.println(collect);
        final Map<String, Set<String>> collect1 = getSonnet().stream()
                .collect(groupingBy(line -> String.valueOf(line.split(" +")[0].charAt(0)),
                        mapping(line -> line.split(" +")[0], toSet())));
        System.out.println(collect1);
    }

    public static void generateFrequencyTable() {

        final Map<String, Long> collect = getSonnet().stream()
                .map(AlphabetSonnetExample::expandStr)
                .flatMap(Collection::stream)
                .collect(groupingBy(key -> key, counting()));
        System.out.println(collect);
    }

    static List<String> expand(String s) {
        return s.codePoints()
                .mapToObj(codePoint -> Character.toString((char) codePoint))
                .collect(toList());
    }

    public static void someTestingCollections() {
        final List<String> collect = getSonnet().stream()
                .map(AlphabetSonnetExample::expandStr)
                .flatMap(t -> t.stream())
                .collect(toList());
        System.out.println(collect);
        final List<String> collect1 = getSonnet().stream()
                .flatMap(line -> expand(line).stream())
                .collect(toList());
        System.out.println(collect1);
        System.out.println(collect.equals(collect1));
        final Map<String, Long> collect2 = collect1.stream()
                .collect(groupingBy(key -> key, counting()));
        System.out.println(collect2);
    }

    public static void countWordInSonetThenGetMax() {

        Pattern pattern = Pattern.compile(("[ ,':\\-]+"));
//        pattern.splitAsStream((CharSequence) getSonnet());
//       pattern.splitAsStream(getSonnet().stream())
        final Map<String, Long> collect = getSonnet().stream()
                .map(String::toLowerCase)
                .flatMap(pattern::splitAsStream)
                .collect(groupingBy(word -> word, counting()));
        System.out.println(collect);
        final Map.Entry<String, Long> empty = collect.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(Map.entry("Empty", 0l));
        System.out.println(empty);

        // invert map to values as KEY, and key as values.
        final Map<Long, List<String>> collect1 = collect.entrySet()
                .stream()
                .collect(groupingBy(Map.Entry::getValue, mapping(Map.Entry::getKey, toList())));
        System.out.println(collect1);
    }


    public static void overlapbyIndexSubArrays(int elemInArr) {
        final int size = getAlphabet().size();
        final List<List<String>> collect = IntStream.range(0, size - elemInArr + 1)
                .mapToObj(index -> getAlphabet().subList(index, elemInArr + index))
                .collect(toList());
        System.out.println(collect);

        //other way
        final List<List<String>> collect1 = IntStream.rangeClosed(elemInArr, size)
                .mapToObj(index -> getAlphabet().subList(index - elemInArr, index))
                .collect(toList());
        System.out.println(collect1);
    }

    public static void nonDecreasingSubList() {
        final List<String> alphabet = getAlphabet();
        final List<Integer> breakOfList = IntStream.range(1, alphabet.size())
                .filter(item ->
                        alphabet.get(item)
                                .length() < alphabet.get(item - 1)
                                .length()
                )
                .boxed()
                .collect(toList());
        System.out.println(breakOfList);

        // we can add this things into breaks before for example  from line @line 152
        breakOfList.add(0,0); // we adding index 0 at begining
        breakOfList.add(alphabet.size()); // we adding index 0 at begining
        System.out.println(breakOfList);
        final List<List<String>> collect = IntStream.range(0,
                breakOfList.size() - 1) // 0 to possition of elements to be divide
                .mapToObj(i -> alphabet.subList(breakOfList.get(i), breakOfList.get(i + 1)))
                .collect(toList());
//        collect.add(0,alphabet.subList(0,breakOfList.get(0))); // we need add the last item.

        System.out.println(collect);
    }
}
