package ChapterCodilityChallanges;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class OddOccurrencesInArray {


    public static void main(String[] args) {


    }
        public int solutionOddOccurrences(int[] A){
            int counter = -1 ;
            int unique = -1;
            for (int i = 0; i < A.length; i++) {

                for (int j = i+1; j < A.length; j++) {
                    System.out.println("i "+ i + "j" + j );
                    if (A[i] == A[j]) {
                      //  System.out.println("times" + j );
                        counter=1;
                        break;
                    }
                }
                if( counter != -1){
                  counter= -1;
                    System.out.println("test");
                }else  {
                    System.out.println("else");
                    unique=A[i];
                }
            }
            return unique;
        }


    @Test
    public void testOccurernces(){
       assertEquals(12,new OddOccurrencesInArray().solutionOddOccurrences(new int[]{11,10,10,9,2,2,9,7,7,9,11,12}));
//       assertTrue();
//       assertTrue();
    }
}
