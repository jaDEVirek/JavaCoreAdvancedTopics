package ChapterCodilityChallanges;


/**
 * Next Codility challange Lesson 3
 *100% solution
 *
 * Important : we need to keep on Abs math on diffrence using X-Y as sum, not to use plus operattor
 * -> complexity O(n)
 */
public class TapeEquilibrium {

    public static void main(String[] args) {
        int array[] = new int[]{3,1,2,4,3};
        int array2[] = new int[]{-1000,1000};
        int array3[] = new int[]{50,15};

        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        System.out.println(tapeEquilibrium.solution(array));
        System.out.println(tapeEquilibrium.solution(array2));
        System.out.println(tapeEquilibrium.solution(array3));
    }

    public int solution(int[] A){
        double leftSide=0;
        double rightSide=0;
        double diff;

        for(int i=1;i<A.length;i++ ){
            rightSide +=A[i];
        }
        leftSide=A[0];
        diff = Math.abs((leftSide-rightSide));
        for(int val=1; val < A.length; val++){
            if(Math.abs(leftSide-rightSide) < diff){
                diff= Math.abs(leftSide-rightSide);
            }
            leftSide+=A[val];
            rightSide-=A[val];
        }

        return (int)diff;
    };
}
