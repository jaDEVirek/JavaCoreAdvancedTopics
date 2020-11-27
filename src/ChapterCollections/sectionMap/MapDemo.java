package ChapterCollections.sectionMap;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {


    public static void main(String[] args) {
        Map<String,String> testMap = new HashMap<>();

        testMap.put(null,"something");
        testMap.put(null,"something");

        testMap.forEach((k,v) -> System.out.println(k+" value " + v ) );
     }
}
