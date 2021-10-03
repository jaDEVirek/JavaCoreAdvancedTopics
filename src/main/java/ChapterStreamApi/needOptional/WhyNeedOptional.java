package ChapterStreamApi.needOptional;


import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WhyNeedOptional {
    private String storeData;

    public static void main(String[] args) {
        List<String> strings = List.of("1", "2", "5", "4");

        WhyNeedOptional whyNeedOptional = new WhyNeedOptional();
        String firstElem = whyNeedOptional.someValueById(strings, 1);
        String secondElem = whyNeedOptional.someValueById(strings, 5);
        System.out.println("Exist: " + firstElem);
        System.out.println("Exist: " + secondElem);
        String noPresent = whyNeedOptional.valueByIdWithPresent(strings, 8);
        String present = whyNeedOptional.valueByIdWithPresent(strings, 2);
        System.out.println("No present: " + noPresent);
        System.out.println("Present: " + present);

        List<Customer> customers = List.of(new Customer("Wiktor", null, null, 1));

        System.out.println(whyNeedOptional.getCustomerByName(customers, null));
        System.out.println(Optional.of("Test")
                .get()
                .equals("Test"));
        whyNeedOptional.flatMappingCustomer(customers,"Wiktor");
        System.out.println(whyNeedOptional.storeData);
    }

    /**
     * Method return value, but problem is that get() method can throw an exception.
     *
     * @param items
     * @param itemId
     * @return
     * @throws NoSuchElementException
     */
    public String someValueById(List<String> items, int itemId) throws NoSuchElementException {
        return items.stream()
                .filter(item -> item.equals(String.valueOf(itemId)))
                .findFirst() // here better to use ifPresent :)
                .get();
    }

    public String valueByIdWithPresent(List<String> items, int itemId) {
        Optional<String> value = items.stream()
                .filter(item -> item.equals(String.valueOf(itemId)))
                .findFirst();// here better to use ifPresent :)
//           return  (value.isPresent() ? value.get() : value.orElse("UNKNOWN"));
        return (value.orElse("UNKNOWN"));
    }


    public String getCustomerByName(List<Customer> customers, String name) {
        return customers.stream()
                .filter(c -> c.getfName()
                        .equals(name))
                .findFirst()
                .map(Customer::getfName)
                .orElse("Not found");
    }

    public void flatMappingCustomer(List<Customer> customers, String name) {
        // we can use optional::... reference from JDK 9 when we have nested object wrapped by Optional
        Stream<Optional<List<Customer>>> optionalStream = Optional.of(customers)
                .stream()
                .map(Optional::of);
        List<Customer> customerStream = optionalStream.flatMap(Optional::stream)
                .flatMap(Collection::stream).collect(Collectors.toList());

            customerStream.stream().filter(t->t.getfName().equals(name)).findFirst().ifPresent(t->getNameOfUser(t.getfName()));
    }
    private String getNameOfUser(String userName){
        this.storeData = userName;
        return userName;
    }
}
