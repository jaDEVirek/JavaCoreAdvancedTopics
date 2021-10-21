package ChapterStreamApi.sectionStreamOperations;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class AlphabetSonnetExample {

    private static List<String> alphabet =
            List.of("alfa", "bravo", "charlie", "delta", "echo",
                    "foxtrot", "golf", "hotel", "india", "juliet",
                    "kilo", "lima", "mike", "november", "oscar",
                    "papa", "quebec", "romeo", "sierra", "tango",
                    "uniform", "victor", "whiskey", "x-ray", "yankee",
                    "zulu");

    private static List<String> sonnet = List.of(
            "From fairest creatures we desire increase,",
            "That thereby beauty's rose might never die,",
            "But as the riper should by time decease,",
            "His tender heir might bear his memory:",
            "But thou contracted to thine own bright eyes,",
            "Feed'st thy light's flame with self-substantial fuel,",
            "Making a famine where abundance lies,",
            "Thy self thy foe, to thy sweet self too cruel:",
            "Thou that art now the world's fresh ornament,",
            "And only herald to the gaudy spring,",
            "Within thine own bud buriest thy content,",
            "And, tender churl, mak'st waste in niggarding:",
            "Pity the world, or else this glutton be,",
            "To eat the world's due, by the grave and thee.");

    public static void main(String[] args) {
        String test = "now Y";
        System.out.println(expandStr(test));

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
        Function<String, StringBuilder> addOneBang2 = StringBuilder::new;
               addOneBang2.apply("This");

        StringBuilder res1 = addBangs.apply("Java has gone functional", 2);
        StringBuilder res2 = addOneBang.apply("Lambdas are sweet");
        StringBuilder res3 = addEllipsis.apply("To be continued");
        System.out.println(res1.toString());
        System.out.println(res2.toString());
        System.out.println(res3.toString());


    }

    public static List<String> expandStr(String str){
        return  Arrays.asList(str.replaceAll("\\s++", "").toLowerCase().split(""));
    }

    /**
     * Appends a {@code character} a couple of {@code times} to a {@code string}.
     *
     * @return the string with the appended characters as a StringBuilder
     */
    private static StringBuilder appendChar(char character, int times, String string) {
        StringBuilder strBuilder = new StringBuilder(string);
        strBuilder.append(String.valueOf(character)
                .repeat(Math.max(0, times)));
        return strBuilder;
    }

    public static List<String> getAlphabet() {
        return alphabet;
    }

    public static List<String> getSonnet() {
        return sonnet;
    }
}
