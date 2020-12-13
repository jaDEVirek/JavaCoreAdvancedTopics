package ChapterCodilityChallanges;


import java.util.Arrays;

public class MaxCounters {

    public static void main(String[] args) {
    int [] arr = new int[]{3,4,4,6,1,4,4};
        System.out.println(Arrays.toString(new MaxCounters().solution(5, arr)) );
    }

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int actualMax = 0;
        int actualMaxRemb= 0;

        for (int i = 0; i < A.length; i++) {
            if (N + 1 == A[i]) {
                actualMaxRemb++;
            } else {
                if(actualMaxRemb > 0) {
                    actualMax++;
                    actualMaxRemb--;
                }
                    ++counters[A[i] - 1];
                actualMax = Math.max(actualMax,counters[A[i]-1]);
            }
        }
        return counters;
    }
}
