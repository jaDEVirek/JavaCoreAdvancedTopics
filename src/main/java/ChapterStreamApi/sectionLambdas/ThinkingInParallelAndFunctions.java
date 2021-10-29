package ChapterStreamApi.sectionLambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ThinkingInParallelAndFunctions {

    public static void main(String[] args) {
//        final List<Predicate<String>> objectList = List.of(i -> i.startsWith("A"), i -> i.length() > 3);
//        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom", "Ana");
//        List<String> result = names.stream()
////                .filter(reducePredicates(objectList),names.get(0))
//                .collect(Collectors.toList());
//        System.out.println(result);
//
////                .substring(5, 8);
////        System.out.println(substring);
////        System.out.println(c);
//        reducePredicates(objectList, names.get(0));
//        thinkinInParallel();
//        final boolean b = xyzThere("a.xyz.abc");
//        System.out.println(b);
        thinkinInParallel();
    }

    public static <T> Predicate<T> reducePredicates(List<Predicate<T>> operatorsPred, String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.substring(i + 8, i + 3));
        }

        return operatorsPred.stream()
                .reduce(t -> true, Predicate::and);
    }


    public static void thinkinInParallel() {
        List<String> test = List.of("1", "5", "#", "3", "4", "1", "#", "7");
        List<Integer> store = new ArrayList<>();
        int iterator = 0;
        final int[] collectInt = IntStream.rangeClosed(0, test.size() - 1)
                .filter(x -> test.get(x)
                        .contains("#"))
                .toArray();

        IntStream.rangeClosed(0, collectInt.length-1)
                .mapToObj(x -> test.subList(,collectInt[x]))


    }

    public static boolean xyzThere(String str) {
        String xyz = "xyz";

        if (str.length() < 3) {
            return false;
        }
        for (int i = 0; i < str.length() - 2; i++) {
            String temp = str.substring(i, i + 3);
            int sign = str.charAt(i);
            if (sign != 46 && temp.compareTo(xyz) == 0) {
                return true;
            }
        }
        return false;
    }
}

