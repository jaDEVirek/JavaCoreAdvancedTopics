package ChapterFunctionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionDemo {


    public static void main(String[] args) {
        // to dont throw an Unsupported exception we need wrap list to arrayList, to return resizable list
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 8, 9, 7));
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {          // o(n^2)  complexity, bcs of shifting
            Integer next = iterator.next();
            if (next.equals(5)) {
                iterator.remove();
            }
        }
        System.out.println(integers);
        //just performed by o(n)
        integers.removeIf(el -> el > 6);

        // in java 8 we can use better way to replace elements
        integers.replaceAll(elem -> elem ^ 2); // bit XOR 0010 XOR 0010 -> for example
        System.out.println(integers); //XOR ON 3^2 0011 0010 --> 0001 => 1

        integers.sort(Comparator.reverseOrder());
        Collections.addAll(integers, 1);
//        runCollectorsAndCollector();
        workingWithMap();
        youCantDoThat();

    }

    private static <T> String fixer(T str) {
        return str.toString();
    }

    public static void runCollectorsAndCollector() {
        Stream<String> s = Stream.of("what", "so", "ever");
        String str = s.collect(Collectors.joining());
        System.out.println(str);
        Function<Object, String> joining = (Function<Object, String>) Collectors.joining(str)
                .finisher();

        String apply = joining.apply(s);
        System.out.println(apply);
        Function<String, String> before = str1 -> str1.concat(str1);
//        joining.finisher().apply(fixer(before.apply(str)));
    }

    public static void workingWithMap() {
        Map<String, Integer> vehicles = new Hashtable<>();
        // Add some vehicles.
        vehicles.put("BMW", 5);
        vehicles.put("Mercedes", 3);
        vehicles.put("Audi", 4);
        vehicles.put("Ford", 10);
//       vehicles.replaceAll((k,v) ->v.floatValue());

        Set<String> strings = new HashSet<>(vehicles.keySet());
        Map<String, Set<String>> multimap = new HashMap<>();
        multimap.put("Jeden", strings);
        System.out.println(multimap.get("Jeden"));
        strings.add("A siemanko");
        System.out.println(multimap.get("Jeden"));

        multimap.get("Jeden")
                .add("dodaje");
        multimap.computeIfAbsent("NoExist",x-> new HashSet<String>()).add("Nowo-Zrobiony");
        System.out.println(multimap.toString());
        Integer reduce = multimap.values()
                .stream()
                .map(Set::size)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    public static void youCantDoThat() {
        String[] flowers = {"Ageratum", "Allium", "Poppy", "Catmint"};
        List<String> flowerList = Arrays.asList(flowers);
        List<String> flowers1 = List.of(flowers);
        // cant add to flowers1 and flowerList bcs its return ValueBased lists
//       flowers1.add("Celosia");
        List<String> arrayList = new ArrayList<String>(Arrays.asList(flowers));
        arrayList.add("new");
        System.out.println(arrayList);

    }
}
