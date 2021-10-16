package ChapterStreamApi.sectionStreamOperations;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateExamples {

    public static void main(String[] args) {
        negativePredicate();
        xorExamplePredicate();
    }


    public static void negativePredicate(){
        Predicate<String> predicateEmpty = Objects::nonNull;
        Predicate<String> predicateNot =  t-> !t.isEmpty();
        Predicate<String> notNullOrNotEmpty = predicateEmpty.and(predicateNot);

        System.out.println(predicateEmpty.test("")); // true
        System.out.println(predicateNot.test("")); // false but true if not empty
        System.out.println(predicateNot.test("Not EMPTY")); // true

        System.out.println("Predicate nullOrNotEmpty: ");
        System.out.println(notNullOrNotEmpty.test("")); //false
        System.out.println(notNullOrNotEmpty.test(null)); // false
        System.out.println(notNullOrNotEmpty.test("Not Empty")); //true
    }

    public static void xorExamplePredicate(){
        Predicate<String> p1 = s -> s.length() == 4;
        Predicate<String> p2 =  t-> t.startsWith("J");

        Predicate<String> p3 = p1.and(p2.negate()).or(p1.negate().and(p2));
        Predicate<String> p4 = xor(p1,p2);
        System.out.println("XOR: ");
        System.out.println(p3.test("True"));
        System.out.println(p3.test("Java"));
        System.out.println(p3.test("Julis"));

        System.out.println(p4.test("True"));
        System.out.println(p4.test("Java"));
        System.out.println(p4.test("Julis"));
    }
    private static <T> Predicate<T> xor(Predicate<T> pred1, Predicate<T> pred2) {
        return t -> pred1.test(t) ^ pred2.test(t);
    }
}
