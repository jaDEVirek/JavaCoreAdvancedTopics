package ChapterCodilityChallanges;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


/**
 *
 */
public class CyclingRotation {

    public static void main(String[] args) {
        new CyclingRotation().solution(new int[]{1, 2, 4, 3}, 3);
        new CyclingRotation().solution(new int[]{3, 8, 9, 7, 6}, 91);
    }


    public int[] solution(int[] A, int K) {
        int lengthArr = A.length;
        if (K == lengthArr) {
            return A;
        }
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i + K < lengthArr) {
                B[i + K] = A[i];
            } else {
                B[(i + K) % lengthArr] = A[i];
            }
        }
        return B;
    }

    @Test
    public void testSolutionCycling() {
        int[] array1 = new int[]{1, 3, 6, 4, 1, 2};
        int[] array2 = new int[]{1, 2, 3};

        assertArrayEquals(array2, new CyclingRotation().solution(array2, 3));
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, new CyclingRotation().solution(new int[]{3, 8, 9, 7, 6}, 3));
        assertArrayEquals(new int[]{2, 1, 3, 6, 4, 1}, new CyclingRotation().solution(array1, 31));
    }
}
