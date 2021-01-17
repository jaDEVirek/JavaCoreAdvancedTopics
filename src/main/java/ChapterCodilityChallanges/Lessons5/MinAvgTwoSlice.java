package ChapterCodilityChallanges.Lessons5;

/**
 * MinAvgTwoSlice codility task- lesson5
 * <p>
 * Find the minimal average of any slice containing at least two elements.
 * <p>
 * Detected time complexity:
 * O(N)
 * 100% solution task
 */
public class MinAvgTwoSlice {

    public static void main(String[] args) {
        System.out.println(new MinAvgTwoSlice().solution(new int[]{4, 2, 2, 5, 1, 8, 5}));
    }

    public int solution(int[] A) {
        float maxINT = Integer.MAX_VALUE;
        int minPossition = 0;

        // https://www.martinkysel.com/codility-minavgtwoslice-solution/ information about problem
        for (int i = 0; i < A.length - 2; i++) {
            float avgBy2 = (float) (A[i] + A[i + 1]) / 2;
            float avgBy3 = (float) (A[i] + A[i + 1] + A[i + 2]) / 3;

            float actualAvg = Math.min(avgBy2, avgBy3);
            if (actualAvg < maxINT) {
                maxINT = actualAvg;
                minPossition = i;
            }
        }
        //for the end of array
        //for last missing case
        int avgBy2 = (A[A.length - 2] + A[A.length - 1]) / 2;
        if (avgBy2 < maxINT) {
            minPossition = A.length - 2;
        }
        return minPossition;
    }
}
