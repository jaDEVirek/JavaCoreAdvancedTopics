package ChapterCodilityChallanges;

/**
 * Codility FrogJmp problem solution
 */
public class FrogJmp {

    public static void main(String[] args) {
        System.out.println(new FrogJmp().solution(10,85,30));
        System.out.println(new FrogJmp().solution(10,85,59));
        System.out.println(new FrogJmp().solution(25,85,100));
        System.out.println(new FrogJmp().solution(5,105,3));


        System.out.println(new FrogJmp().solutionTwo(1,105,1));
        System.out.println(new FrogJmp().solutionTwo(104,105,1000));
        System.out.println(new FrogJmp().solutionTwo(50,199,4));
        System.out.println(new FrogJmp().solutionTwo(105,105,1000));
    }


    /**
     * 44 % solution problem
     * @param X
     * @param Y
     * @param D
     * @return
     */
    public int solution(int X, int Y, int D) {
        int maxJumps =  Y/D;
        int possition = X+(maxJumps*D);
        if(possition < Y){
            return maxJumps+1;
        }else if(X+((maxJumps-1)*D) >= Y ) {
                return maxJumps-1;
        }else
            return maxJumps;
    }

    /**
     *  RESULT - 100 %  gives O(1) complexity !!!
     * @param X
     * @param Y
     * @param D
     * @return
     */
    public int solutionTwo(int X, int Y, int D) {
        int result= Y-X;
        if(result == 0 ){
            return 0;
        }else if(result%D == 0){
            return result/D;
        }else{
            return (result/D)+1;
        }
    }
}
