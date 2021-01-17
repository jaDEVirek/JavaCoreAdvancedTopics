package ChapterCodilityChallanges.Lessons5;

/**
 * PassingCars - > solution problem Lesson5 in Codility task
 * 100% worked with performed method.
 * Complexity O(n)
 */
public class PassingCars {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 1, 1};
        PassingCars passingCars = new PassingCars();
        System.out.println(passingCars.solution(array));
        System.out.println(passingCars.performanceSolution(array));

    }

    /*
        Solution is to slow - > 50%
        A little bad complexity, example
     */
    public int solution(int[] A) {
        int pairs = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] == 1) {
                        pairs++;
                    }
                }
            }
        }
        return pairs;
    }

    /*
        100% solution based on complexity O(n)
        we need check last if statement,
        that was what the task required
     */
    public int performanceSolution(int[] A) {
        int countZeros = 0;
        int pairs = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                countZeros++;
            }
            if (A[i] == 1) {
                pairs += countZeros;
            }
            if (pairs > 1000000000) {
                return -1;
            }
        }
        return pairs;
    }
}
