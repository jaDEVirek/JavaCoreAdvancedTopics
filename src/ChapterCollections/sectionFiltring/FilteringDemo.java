package ChapterCollections.sectionFiltring;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
public class FilteringDemo {


    public static void main(String[] args) {
        FilteringDemo filteringDemo = new FilteringDemo();
        System.out.println();
    }

    public void iteratorFiltering() {
        Iterator<Person> iterator = NamesData.prepareDataNames()
                .listIterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person);
            if (person.getfName()
                    .contains("a")) {
                iterator.remove();
            }
        }
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
