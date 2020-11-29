package ChapterCollections.sectionMap;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

static String a= "nono null";
    public static void main(String[] args) {
        Map<String,String> testMap = new HashMap<>();

        testMap.put(null,"something");
        testMap.put(null,"something");
        System.out.println(a);
         a = "times";

        System.out.println(a);
        testMap.forEach((k,v) -> System.out.println(k+" value " + v ) );
     }
}
