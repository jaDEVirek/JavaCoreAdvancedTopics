package ChapterCodilityChallanges;


import java.util.Arrays;

/**
 * MissingInteger problem Codility Lesson 4 - tasks
 *
 * Solution 100% - > complexity O(N) or O(N * log(N))
 */
public class MissingInteger {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 4, 1, 7};
        int solution = new MissingInteger().solution(array);
        System.out.println(solution);

    }

    public int solution(int A[]) {
        Arrays.sort(A);
        int minVal = 1;
        for (int val : A) {
            if (val == minVal) {
                 minVal++;
            }
        }
        return minVal;
    }
}
