package ChapterCodilityChallanges;


import java.util.HashSet;
import java.util.Set;

/**
 * FrogRiverOne - Lesson 4. Codility Problem
 * <p>
 * O(n) complexity, 100% solution.
 * We need keep on set all operation, becouse ArrayList is too slow. and gives O(n^2)
 */
public class FrogRiverOne {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 1, 4, 2, 3, 5, 4};
        int solution = new FrogRiverOne().solution(arr, 5);
        System.out.println(solution);
    }

    // 100% solution
    public int solution(int[] A, int X) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if (set.size() == X) return i;
        }
        return -1;
    }
}
