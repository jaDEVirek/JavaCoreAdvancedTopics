package ChapterCodilityChallanges;


import java.util.*;

/**
 *   100% Passed solution.
 *   Complexity between O(n) or O(n*log(n))
 */
public class PermCheck {


    public static void main(String[] args) {
        int[] array1 = new int[]{4,1,3,2};
        int[] array3 = new int[]{2};
        int[] array2 = new int[]{4,1,3,6,2,2};


        System.out.println("Solution: " + new PermCheck().solution(array1));
        System.out.println("Solution: " + new PermCheck().solution(array2));
        System.out.println("Solution: " + new PermCheck().solution(array3));
    }


    public  int solution(int []array){
        if(array.length == 1 && array[0] != 1){
            return 0;
        }
        Set<Integer> setOfInt = new HashSet<>();
        for(int el : array){
            if(setOfInt.add(el)){
            }else{
                return 0;
            }
        }
        List<Integer> setAsList = new ArrayList<>(setOfInt);
        Collections.sort(setAsList);
        if(setAsList.get(0) !=1){
            return 0;
        }
        for (int i=0; i<setAsList.size()-1;i++) {
            if(setAsList.get(i)+1 != setAsList.get(i+1)){
                    return 0;
            }
        }
        return 1;
    }
}
