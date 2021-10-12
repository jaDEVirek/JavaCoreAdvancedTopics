package ChapterFunctionalProgramming;

import ChapterCollections.sectionFiltring.Person;
import ChapterStreamApi.needOptional.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
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
        //  customers.sort(new LamdaCollectionPartTwo().comapreBylName);
        // System.out.println(customers.toString());
//        Arrays.stream(Employee.initData())
//                .sorted(Comparator.comparing(Employee::getId))
//                .forEach(System.out::println);
        Employee[] employees = Employee.initData();
        Arrays.sort(employees);
        Arrays.stream(employees)
                .forEach(System.out::println);

        Map<Integer, ? extends Serializable> integerMap = Map.of(1, "One", 2, "Two", 3, 3);
        Map<Integer, ? extends Object> one = Map.ofEntries(Map.entry(1, "One"), Map.entry(2, 2));

        Serializable serializable = integerMap.get(2);

        System.out.println(serializable.toString());
        System.out.println(integerMap);
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

    public static void testingWithNulls() {

        // Create a collection of an array
        // of names also contain nulls
        String[] strings = {"aman", "suvam",
                null, "sahil",
                null};

        // print the array
        System.out.println("Before sorting: "
                + Arrays.toString(strings));

        // apply nullsFirst method
        // and sort the array
        Arrays.sort(strings,
                Comparator.nullsFirst(
                        Comparator.naturalOrder()));

        // print the array
        System.out.println("After sorting: "
                + Arrays.toString(strings));
    }
}


@AllArgsConstructor
@Data
class Employee implements Comparator<Employee>, Comparable<Employee> {
    int id;
    String name;
    double salary;
    long mobile;


    public static Employee[] initData() {
        return new Employee[]{new Employee(1, "Jeff Bezos", 900000.0, 758566),
                new Employee(2, "Bill Gates", 200000.0, 234232),
                new Employee(3, "Mark Zuckerberg", 700000.0, 2342342),
                new Employee(4, "Sunder Pichai", 400000.0, 34242222),
                new Employee(5, "Tom Peterson", 400000.0, 8736432),
                new Employee(6, "Zed Adams", 7600.0, 8736432)};
    }

    @Override public int compare(Employee o1, Employee o2) {
        return (int) (o1.getSalary() - o2.getSalary());
    }

    @Override public int compareTo(Employee o) {
        return  ((this.name).compareTo(o.getName()));
    }
}
