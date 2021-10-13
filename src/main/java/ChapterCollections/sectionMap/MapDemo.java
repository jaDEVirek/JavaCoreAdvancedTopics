package ChapterCollections.sectionMap;

import java.util.*;
import java.util.stream.Collectors;

public class MapDemo {

    public static void main(String[] args) {
        demoForMap();

    }


    private static void demoForMap() {
        Map<Integer, String> integerStringMap = Map.ofEntries(Map.entry(0x0002, "Auto"),
                Map.entry(0x0004, "Sunny"),
                Map.entry(0x0005, "Fluorescent"),
                Map.entry(0x0006, "Flash"),
                Map.entry(0x0007, "Cloudy"),
                Map.entry(0x8010, "Shade"),
                Map.entry(0x8012, "Custom"),
                Map.entry(0x8013, "Preset"));
        Map<Integer, String> resizableMap = new HashMap<>();

//        Map<Integer, String> mutableMap =  new HashMap<>().putAll(integerStringMap);
        resizableMap.put(0x3301, "NotFound");
        boolean remove = resizableMap.keySet()
                .remove(0x0007);
        System.out.println(remove); // false
        Collection<String> values = resizableMap.values();
        System.out.println(values);
//        values.add("test"); unsupported
        Set<Integer> integers = resizableMap.keySet();
//        integers.add(111); unsupported
//        resizableMap.keySet().add(67);  unsupported
        System.out.println(integers);
        resizableMap.putAll(integerStringMap);
        // if we modify-remove elements from keySet, or Values, then we modify -> map too !
        // we can add element to view using iterator only
        Set<Map.Entry<Integer, String>> entries = resizableMap.entrySet();
//        entries.add(Map.entry(99,"we can")); unsupported
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        Map.Entry<Integer, String> next = iterator.next();
        next.setValue("Here you Can modify");
        System.out.println(resizableMap);
        System.out.println("\n\n\n\nTEST SOLUTION: \n");
        solutionAttemptForMaps();
    }


    /**
     * HOW TO return keySet based on permutation in two maps ?
     */

    public static void solutionAttemptForMaps() {
        Map<Integer, String> mapA = Map.of(1, "a", 2, "b", 3, "c");
        Map<Integer, String> mapB = Map.of(5, "a", 6, "d", 7, "c");

        // EXPECTED [5.7]

        //SOLUTION 1
        List<Integer> collect = mapB.entrySet()
                .stream()
                .filter(entry -> mapA
                        .containsValue(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(collect);

        //SOLUTION 2
        // retains the best way
        HashMap<Integer, String> copyOfMapB = new HashMap<>(mapB);
        copyOfMapB.values().retainAll(new HashSet<>(mapA.values()));
        Set<Integer> values = copyOfMapB.keySet();
        System.out.println("with Retain ?" + values);
    }
}
