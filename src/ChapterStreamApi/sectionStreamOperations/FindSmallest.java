package ChapterStreamApi.sectionStreamOperations;


import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindSmallest {


    public static void main(String[] args) {
        int array1[] = new int[]{1,3,6,4,1,2};
        int array2[] = new int[]{1,2,3};
        int array3[] = new int[]{-1,-2,-3};

        System.out.println(new FindSmallest().solution(array1));;
        System.out.println(new FindSmallest().solution(array2));;
        System.out.println(new FindSmallest().solution(array3));;
    }

    public int solution(int[] arr){
        int max = Stream.of(arr)
                .flatMapToInt(IntStream::of)
                .max().getAsInt();

        System.out.println("Max " + max );

        List<Integer> collect = IntStream.of(arr)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        int min = findMin(max, collect);
        if(max <=0){
            return 1;
        }
        else if(min == -1){
            return max +1;
        }else{
            return min;
        }
    }

    private int findMin(int max, List<Integer> integers)  {
        if(max == 1){
            return -1;
        }
        integers.remove(Integer.valueOf(max));

        Integer integer = integers.get(integers.size()-1);
        System.out.println("Get " + integer);
        if(integer == max - 1 && integer >0){
            return findMin(max-1,integers);
        }else{
            return max-1;
        }
    }
}
