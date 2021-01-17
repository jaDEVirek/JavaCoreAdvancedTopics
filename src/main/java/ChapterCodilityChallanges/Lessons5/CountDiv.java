package ChapterCodilityChallanges.Lessons5;

/**
 *
 *  Complexity is  perfect O(1) operation
 *     100%  with solutionPerformance method
 */
public class CountDiv {

    public static void main(String[] args) {
        CountDiv countDiv = new CountDiv();
        System.out.println(countDiv.solution(6, 11, 2));
        System.out.println(countDiv.recursiveSolution(6, 11, 2));
        System.out.println(countDiv.solutionPerformance(6, 11, 2));

    }

    /*
        Complexity O(M+N) ... not pass all test.
     */
    public int solution(int A, int B, int K) {
        int divs = 0;

        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                divs++;
            }
        }
        return divs;
    }

    /*
     Complexity is a bit worth
     */
    public int recursiveSolution(int A, int B, int K) {
        if (A > B) {
            return 0;
        }
        return (A % K == 0 ? 1 : 0) + recursiveSolution(A + 1, B, K);

    }

    /*
    Complexity is  perfect O(1) operation
    100%
    */
    public int solutionPerformance(int A, int B, int K) {
        int calculate = 0;
        if (A % K == 0) {
            calculate++;
        }
        calculate += (B / K) - (A / K);
        return calculate;
    }
}
