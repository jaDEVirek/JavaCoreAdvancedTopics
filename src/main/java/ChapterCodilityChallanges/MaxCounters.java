package ChapterCodilityChallanges;


import java.util.Arrays;

/**
 * Codility MaxCounter solution 100%
 *
 * Problem was complexity: to make better performance then M*N or N^2
 * Detected time complexity:
 * O(N + M)
 *
 */
public class MaxCounters {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 4, 6, 1, 4, 4};
        System.out.println(Arrays.toString(new MaxCounters().solution(5, arr)));
    }

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int actualMax = 0;
        int actualMaxRemb = 0;
        boolean noMax = false;

        for (int value : A) {
            if (N + 1 == value) {
                if (!noMax) {
                    actualMaxRemb += actualMax;
                    actualMax = 0;
                    counters = new int[N];
                    noMax = true;
                }

            } else {
                ++counters[value - 1];
                actualMax = Math.max(counters[value - 1], actualMax);
                noMax = false;
            }
        }
        for (int i = 0; i < counters.length; i++) {
            counters[i] += actualMaxRemb;
        }
        return counters;
    }
}
