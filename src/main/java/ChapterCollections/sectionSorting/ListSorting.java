package ChapterCollections.sectionSorting;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 *
 *
 */
public class ListSorting {

    public static void main(String[] args) {


        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("a");
        stringArrayList.add("b");
        stringArrayList.add("c");
        stringArrayList.add("d");

        String s = stringArrayList.get(3);

        LinkedList<String> linkedList = new LinkedList<>(stringArrayList);
        linkedList.add("lA");
        String s1 = linkedList.get(3);

        System.out.println(s);
        System.out.println(s1);
    }
}
