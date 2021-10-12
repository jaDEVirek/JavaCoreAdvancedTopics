package ChapterStreamApi.sectionLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaDemo<T> {

    static List<Jobs> dataJobs = new ArrayList<>() {
        {
            add(new Jobs("Teach Lead"));
            add(new Jobs("Experience Android Developer"));
            add(new Jobs("Platform engineer"));
            add(new Jobs("Java developer"));
            add(new Jobs("DevOps Engineer-Splunk"));
            add(new Jobs("Senior Cloud Software Engineer"));
            add(new Jobs("Big Data Engineer"));
            add(new Jobs("Site Reliability Engineer"));
            add(new Jobs("Sr  Data Engineer"));
            add(new Jobs("Senior Backend Engineer"));
            add(new Jobs("Team-Lead Developer"));
            add(new Jobs("Software Engineer"));
            add(new Jobs("Seeking Full-Time"));
            add(new Jobs("Senior Research"));
            add(new Jobs("Principal Software Engineer"));
            add(new Jobs("SAP Application Expert FI/CO"));
        }
    };

    public static void main(String[] args) {
        Object o = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        List<Object> string = List.of(o, o2, o3, "string");

        List<? super String> superString = string;
        System.out.println(superString.get(1));
//        superString.add("test");
        flatMapping();

    }

    public static  void flatMapping() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        Stream<Stream<Integer>> streamStream = listOfLists.stream()
                .map(List::stream);
        List<Stream<Integer>> collect = streamStream.collect(Collectors.toList());
        Stream<Integer> integerStream2 = listOfLists.stream()
                .flatMap(Collection::stream);
        Stream<Boolean> booleanStream = collect.stream()
                .map(t -> t.findFirst()
                        .isPresent());
        List<Boolean> collect1 = booleanStream.collect(Collectors.toList());
        Integer integerStream = collect.stream()
                .map(t -> t.reduce(1,(x,y)-> x/y)).reduce(1,Integer::sum);
        System.out.println(integerStream);

//                .flatMap(Stream::flatMap);
//                .collect(Collectors.toList());

//        System.out.println(integerStream);
    }
}
