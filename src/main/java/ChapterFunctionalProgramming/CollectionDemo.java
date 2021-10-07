package ChapterFunctionalProgramming;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionDemo {


    public static void main(String[] args) {
        // to dont throw an Unsupported exception we need wrap list to arrayList, to return resizable list
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 8, 9, 7));
        Iterator<Integer> iterator = integers.iterator();
        while(iterator.hasNext()){          // o(n^2)  complexity, bcs of shifting
            Integer next = iterator.next();
            if(next.equals(5)){
                iterator.remove();
            }
        }
        System.out.println(integers);
        //just performed by o(n)
        integers.removeIf(el -> el > 6);

        // in java 8 we can use better way to replace elements
        integers.replaceAll(elem -> elem^2); // bit XOR 0010 XOR 0010 -> for example
        System.out.println(integers); //XOR ON 3^2 0011 0010 --> 0001 => 1

        integers.sort(Comparator.reverseOrder());
        Collections.addAll(integers, 1);
        runCollectorsAndCollector();

    }
    private static  <T> T fixer(T  str){

        return ((String) str) ;
    }
    public static void runCollectorsAndCollector(){
        Stream<String> s = Stream.of("what", "so", "ever");
        String str = s.collect(Collectors.joining());
        System.out.println(str);
        Collector<CharSequence, ?, String> joining = Collectors.joining();
        String s1 = joining.finisher().apply( fixer(str));
    }

}
