package ChapterCodilityChallanges;


import java.util.Arrays;

/**
 * Solution for PermMissingElem - from Codility.
 *Find the missing element in a given permutation
 *
 * 100% solution complexity O(N) or O(N * log(N))
 */
public class PermMissingElem {

    public static void main(String[] args) {
        int array[] = new int[]{2,3,1,5,6,4,8};
        int array2[] = new int[]{2};

        int solution = new PermMissingElem().solution(array);
        System.out.println(new PermMissingElem().solution(array2));
        System.out.println(solution);
    }

    public int solution(int[] A){
        double nVal = A.length+1;
        double sum = 0;
        double sumNval=  ((nVal+1)*nVal)/2;

        for(int val : A){
            sum+=val;
        }
        return (int) (sumNval-sum);
    }

    public int sortingSolution(int[] A) {
        int size = A.length;
        int count = 1;
        Arrays.sort(A);

        for (int i = 0; i < size; i++) {
            if (A[i] != count)
                return count;
            count++;
        }
        return count;
    }

    public int solutionByCheck(int[] A) {
        int missing = 1; // missing number 1 already
        Arrays.sort(A);

        // check numbers one by one
        for (int i = 0; i < A.length; i++) {
            if (A[i] == missing) {    // we found the missing number !
                missing = A[i]+1;    // add +1 and keep checking
            }
        }
        return missing;
    }
}
