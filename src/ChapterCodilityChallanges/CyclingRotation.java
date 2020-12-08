package ChapterCodilityChallanges;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class CyclingRotation {


    public static void main(String[] args) {
        new CyclingRotation().solution(new int[]{1,2,4,3},3);
    }


    public int[] solution(int[] A, int K){
        int lengthArr = A.length;
        System.out.println("length" + A.length);
        if(K == lengthArr){
            return A;
        }
        int []B = new int[A.length];
        for(int i=0;i<A.length;i++){
            if(i+K < lengthArr) {
                System.out.println("times");
                B[i + K] = A[i];
            }
            else{
                B[i+K-lengthArr]= A[i];
            }
        }
        System.out.println(Arrays.toString(B));
        return B;
    }


    @Test
    public void testSolutionCycling(){
        int[] array1 = new int[]{1,3,6,4,1,2};
        int[] array2 = new int[]{1,2,3};
        int[] array2Shifted = new int[]{2,3,1};
        assertEquals(array2, new CyclingRotation().solution(array2,3));
        assertEquals(array2Shifted, new CyclingRotation().solution(new int[]{2,3,1},2));
    }
}
