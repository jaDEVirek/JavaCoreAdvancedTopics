package ChapterCodilityChallanges;


import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class OddOccurrencesInArray {


    public static void main(String[] args) {
        Set<Integer> stringSet = new HashSet<>();
        Integer[] arr = new Integer[];

        for(int i=0; i<arr.length; i++){
            if(stringSet.add(arr[i])){

            }else{
                stringSet.remove(arr[i]);
            }
        }

    }
}
