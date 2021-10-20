package ChapterStreamApi.sectionStreamOperations;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PartialAppJava {



    /*
     * Pass two arguments. The created function accepts a String and
     * returns a StringBuilder
     */
    Function<String, StringBuilder> addEllipsis = appendToMe -> appendChar(
            '.', 3, appendToMe);
    /*
     * Pass one argument. This creates a function that takes another two
     * arguments and returns a StringBuilder
     */
    BiFunction<String, Integer, StringBuilder> addBangs = (appendToMe,
            times) -> appendChar('!', times, appendToMe);

    // Create a function by passing one argument to another function
    Function<String, StringBuilder> addOneBang = appendToMe -> addBangs
            .apply(appendToMe, 1);

    StringBuilder res1 = addBangs.apply("Java has gone functional", 2);
    StringBuilder res2 = addOneBang.apply("Lambdas are sweet");
    StringBuilder res3 = addEllipsis.apply("To be continued");

    /**
     * Appends a {@code character} a couple of {@code times} to a {@code string}.
     *
     * @return the string with the appended characters as a StringBuilder
     */
    private static StringBuilder appendChar(char character, int times, String string) {
        StringBuilder strBuilder = new StringBuilder(string);
        for (int i = 0; i < times; i++) {
            strBuilder.append(character);
        }
        return strBuilder;
    }
}
