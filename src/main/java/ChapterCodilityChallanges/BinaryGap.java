package ChapterCodilityChallanges;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Codility binaryGap solution
 *
 * 100% worked
 * may got problem of optimalization complexity time
 * pessimistic solution is O(n^2) bcs of two iteration based.
 */
public class BinaryGap {

    public static void main(String[] args) {
        new BinaryGap().solution(32);
        new BinaryGap().solution(529);
        new BinaryGap().solution(1041);
    }

    public int solution(int N) {
        int binary[] = new int[100];
        int it = 0;
        int currentGap = 0;
        int maximalGap = 0;
        int firstOne = 0;
        while (N > 0) {
            binary[it] = N % 2;
            N = N / 2;
            it++;
        }
        for (int i = 0; i < binary.length - 1; i++) {
            if (binary[i] == 1) {
                firstOne = i;
                break;
            }
        }
        for (int j = firstOne; j < binary.length - 1; j++) {
            if (binary[j +1] == 0) {
                currentGap++;
            } else {
                if (currentGap > maximalGap) {
                    maximalGap = currentGap;
                }
                currentGap = 0;
            }
        }
        System.out.println(maximalGap);
        return maximalGap;
    }

    @Test
    public void checkSolution() {
        assertEquals(3, new BinaryGap().solution(561892));
        assertEquals(0, new BinaryGap().solution(32));
        assertEquals(0, new BinaryGap().solution(15));
        assertEquals(4, new BinaryGap().solution(529));
        assertEquals(1, new BinaryGap().solution(111));
    }
}
