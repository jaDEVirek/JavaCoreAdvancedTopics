package ChapterStreamApi.needOptional;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class WhyNeedOptional {


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
        Optional<Customer> first = customers.stream()
                .filter(c -> c.getfName()
                        .equals(name))
                .findFirst();
        return first.map(Customer::getfName).orElse("Not found");
    }
}
