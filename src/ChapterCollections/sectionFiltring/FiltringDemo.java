package ChapterCollections.sectionFiltring;

/**
 *
 *
 */
public class FiltringDemo {


    public static void main(String[] args) {
        String replace =  new String("Str");
        String basic= replace;
        System.out.println(basic.hashCode());
        System.out.println(replace.hashCode());
        System.out.println(basic.equals(replace));
        System.out.println(basic == replace);

    }
}
