package ChapterCollections.sectionFiltring;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class FilteringDemo {


    public static void main(String[] args) {
        FilteringDemo filteringDemo = new FilteringDemo();
        filteringDemo.iteratorFiltering();
    }

    public void iteratorFiltering() {
        List<Person> personList = new ArrayList<>();
        int randomInt = new Random().nextInt(40)+10;
        System.out.println("Before remove size" + personList.size());

        Iterator<Person> iterator = NamesData.prepareDataNames()
                .listIterator();
        while (iterator.hasNext() && randomInt >= 1) {
            --randomInt;
            Person person = iterator.next();
            System.out.println(person.toString());
            if (person.getfName()
                    .contains("a")) {
                personList.add(person);
                iterator.remove();
            }
        }
        System.out.println("After remove " + personList.toString());
        System.out.println("After remove size" + personList.size());
    }

    public void removeIf() {
        NamesData.prepareDataNames()
                .removeIf(p -> !p.getfName()
                        .contains("a"));
    }

    public void streamFiltering() {
        Set<Person> personSet = NamesData.prepareDataNames()
                .stream()
                .filter(p -> p.getsName()
                        .endsWith("a"))
                .collect(Collectors.toSet());
        System.out.println(personSet.size());
    }
}
