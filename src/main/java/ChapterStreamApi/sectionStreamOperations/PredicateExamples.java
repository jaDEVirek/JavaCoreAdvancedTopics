package ChapterStreamApi.sectionStreamOperations;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateExamples {

    public static void main(String[] args) {
        negativePredicate();
    }


    public static void negativePredicate(){
        Predicate<String> predicateEmpty = Objects::nonNull;
        Predicate<String> predicateNot =  t-> !t.isEmpty();
        Predicate<String> notNullOrNotEmpty = predicateEmpty.and(predicateNot);

        System.out.println(predicateEmpty.test("")); // true
        System.out.println(predicateNot.test("")); // false but true if not empty
        System.out.println(predicateNot.test("Not EMPTY")); / / true

        System.out.println("Predicate nullOrNotEmpty: ");
        System.out.println(notNullOrNotEmpty.test("")); //false
        System.out.println(notNullOrNotEmpty.test(null)); // false
        System.out.println(notNullOrNotEmpty.test("Not Empty")); //true


    }
}
