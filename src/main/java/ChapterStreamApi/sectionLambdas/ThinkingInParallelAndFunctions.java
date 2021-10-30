package ChapterStreamApi.sectionLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ThinkingInParallelAndFunctions {

    public static void main(String[] args) {
        thinkinInParallel();
        System.out.println(xyzThere("abcxyz"));
        System.out.println(xyzThere("abc.xyz"));
        System.out.println(xyzThere("xyz. pabc"));
        pararllelBetterSoultion();
    }

    public static <T> Predicate<T> reducePredicates(List<Predicate<T>> operatorsPred, String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.substring(i + 8, i + 3));
        }
        return operatorsPred.stream()
                .reduce(t -> true, Predicate::and);
    }


    public static void thinkinInParallel() {
        List<String> test = new ArrayList<>(List.of("1", "5", "#", "3", "4", "1", "#", "7"));
        List<Integer> store = new ArrayList<>();
        final List<Integer> integers = IntStream.range(0, test.size())
                .filter(x -> test.get(x)
                        .equals("#"))
                .boxed()
                .collect(toList());
        store.add(0,-1); // manipulation elemets in that way is a little tricky
        store.addAll(1, integers);
        store.add(test.size());
         int[] ints = store.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("Arr of ints" + Arrays.toString(ints));

        final List<List<String>> collect = IntStream.range(0, ints.length - 1)
                 .mapToObj(x -> test. subList(ints[x] + 1, ints[x + 1]))
                .collect(toList());
        System.out.println("Result:" + collect);
    }

    // reduced to stream
    public static void pararllelBetterSoultion(){
        List<String> test = new ArrayList<>(List.of("1", "5", "#", "3", "4", "1", "#", "7"));
        final int[] ints = IntStream.range(-1, test.size()+1) // we can iterate ower more elements
                .filter(x -> x==-1 ||x == test.size() || test.get(x).equals("#")) // and accept them if true
                .toArray();
        System.out.println("Arr of ints" + Arrays.toString(ints));
        final List<List<String>> collect = IntStream.range(0, ints.length - 1)
                .mapToObj(x -> test.subList(ints[x] + 1, ints[x + 1]))
                .collect(toList());
        System.out.println(collect);
    }

    /**
     *
     *
     */
    public static boolean xyzThere(String str) {
        String xyz = "xyz";

        if (str.length() < 3) {
            return false;
        }
        for (int i = 1; i < str.length() - 2; i++) {
            String temp = str.substring(i-1, i + 2);
            int sign = str.charAt(i-1);
            if (sign != 46 && temp.compareTo(xyz) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     *
     */
    public static Boolean xyzThere2(String str) {
        int len = str.length();
        String xyz = "xyz";
        Boolean match = false;
        if (len < 3)
        return false;
        for (int i = 0; i < len - 2; i ++) {
            String temp = str.substring(i, i+3);
            if (temp.compareTo(xyz) == 0 && i == 0)
            match = true;
    else if( temp.compareTo(xyz) == 0 &&  str.charAt(i-1) != 46  )
            match = true;
        }
        return match;
    }
}

