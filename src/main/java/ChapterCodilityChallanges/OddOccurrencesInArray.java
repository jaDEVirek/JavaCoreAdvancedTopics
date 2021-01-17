package ChapterCodilityChallanges;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 *Two types of implemetation using XOR - go check reference of bit XOR OPERATION
 * 1 - 1 => 0
 * 1 - 0 => 1
 * 0 - 1 => 1
 * 0 - 0 => 0
 * 100% solution for codility problem Lesson
 */
public class OddOccurrencesInArray {


    public static void main(String[] args) {


    }

    public int soultionWithSet(int[] A) {
        Set<Integer> integerSet = new HashSet<>();
        for (int a : A) {
            if (!integerSet.contains(a)) {
                integerSet.add(a);
            } else {
                integerSet.remove(a);
            }
        }
        System.out.println(integerSet);
        return integerSet.iterator()
                .next();
    }

    public int solutionOddOccurrences(int[] A) {
        int result = 0;
        for (int value : A) {
            result ^= value;
        }
        return result;
    }


    @Test
    public void testOccurernces() {
        assertEquals(12,
                new OddOccurrencesInArray().soultionWithSet(new int[]{11, 9, 10, 10, 9, 2, 2, 9, 7, 7, 9, 11, 12}));
        assertEquals(5,
                new OddOccurrencesInArray().soultionWithSet(new int[]{11, 10, 10, 11, 5, 9, 2, 2, 9, 7, 7, 12, 9, 12}));
        assertEquals(1, new OddOccurrencesInArray().soultionWithSet(
                new int[]{11, 1, 11, 10, 10, 9, 2, 2, 9, 7, 7, 9, 11, 12, 12}));
        assertEquals(1, new OddOccurrencesInArray().solutionOddOccurrences(
                new int[]{11, 1, 10, 10, 9, 2, 2, 9, 7, 7, 9, 9, 11, 12, 12}));
        assertEquals(1, new OddOccurrencesInArray().solutionOddOccurrences(new int[]{11, 1, 11,}));
    }
}
