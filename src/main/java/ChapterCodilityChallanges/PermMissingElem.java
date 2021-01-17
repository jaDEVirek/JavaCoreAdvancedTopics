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
        int array3[] = new int[]{5,6,4,8}; // with bad array !
        int array2[] = new int[]{2};

        int solution = new PermMissingElem().solution(array);
        System.out.println(new PermMissingElem().solution(array3));
        System.out.println(solution);

        System.out.println(new PermMissingElem().solutionByCheck(array));
        System.out.println(new PermMissingElem().solutionByCheck(array3));
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

        for (int value : A) {
            if (value != count)
                return count;
            count++;
        }
        return count;
    }

    public int solutionByCheck(int[] A) {
        int missing = 1;
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        // check numbers one by one
        for (int value : A) {
            if (value == missing) {    // we found the missing number !
                System.out.println("found!");
                missing = value + 1;    // add +1 and keep checking
            }
        }
        return missing;
    }
}
