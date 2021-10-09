package ChapterFunctionalProgramming;

import ChapterCollections.sectionFiltring.Person;
import ChapterStreamApi.needOptional.Customer;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class LamdaCollectionPartTwo {


    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Tom", "Martini"));
        customers.add(new Customer("Wiktor", "Reliso"));
        customers.add(new Customer("Alice", "Jonson"));
        customers.add(new Customer("Barty", "Warty"));
        customers.add(new Customer("Adam", "Zedy"));
        customers.add(new Customer("Adam", "Eureka"));
        // we can use comparator comparing if our object not implements comparable
//        Collections.sort(customers, Comparator.comparing(Customer::getfName));
        customers.sort(new LamdaCollectionPartTwo().comapreBylName);
        System.out.println(customers.toString());


    }

    Comparator<Customer> comapreBylName = new Comparator<>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getlName()
                    .compareTo(o2.getlName());
        }
    };

    private static class PersonCollectorImpl implements Collector<Person, List<Person>, List<Person>> {

        @Override public Supplier<List<Person>> supplier() {
            return ArrayList::new;
        }

        @Override public BiConsumer<List<Person>, Person> accumulator() {
            return List::add;
        }

        @Override public BinaryOperator<List<Person>> combiner() {
            return (listA, listB) -> {
                listA.addAll(listB);
                return listA;
            };
        }

        @Override public Function<List<Person>, List<Person>> finisher() {
            return Collections::unmodifiableList;
        }

        @Override public Set<Characteristics> characteristics() {
            return Set.of(Characteristics.CONCURRENT);
        }
    }

    public static PersonCollectorImpl toPersonCollectorList() {
        return new PersonCollectorImpl();
    }
}


