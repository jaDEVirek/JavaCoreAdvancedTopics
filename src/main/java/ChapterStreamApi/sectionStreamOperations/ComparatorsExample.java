package ChapterStreamApi.sectionStreamOperations;

import ChapterCollections.sectionFiltring.Person;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;

public class ComparatorsExample<T> {

    public static void main(String[] args) {
        Person person = new Person("Wiktor", "Reliso");
        Person person2 = new Person(" ", "Reliso");


    }


    public static void comparatorUsingJDK8() {
        //nulls pointers will be checked ! is good idea
       Comparator<Person> cmp = Comparator.comparing(Person::getfName)
                .thenComparing(Person::getsName).thenComparing(Person::getId);

        ComparatorsExample comparatorsExample = new ComparatorsExample();
         comparatorsExample.ownComparator(Person::getfName)
                .thenOwnComparing(Person::getsName);
        // bad example
        Comparator<Person> cmp2 =  new Comparator<Person>() {
            @Override public int compare(Person o1, Person o2) {
                int cmp = o1.getsName().compareTo(o2.getsName());
                if(cmp==0){
                    cmp = o1.getfName().compareTo(o2.getfName());
                    if(cmp==0){
                        return  Long.compare(o1.getId(),o2.getId());
                    }else
                        return cmp;
                }
            return cmp;
            }
        };

    }

    static  <T, R extends Comparable<? super R>> ComparatorsExample<T> ownComparator(Function<? super T, R> function){
        Objects.requireNonNull(function);
        return  ( ob1,  ob2) -> {
            R apply = function.apply(ob1);
            R apply2 = function.apply(ob2);
            return apply.compareTo(apply2);
        };
    }

    public  <T extends  Comparable<? super T>, R extends Comparable<? super R>> ComparatorsExample<T> thenOwnComparing(Function<T, R> function){
        Objects.requireNonNull(function);

        return  (ob1, ob2) -> {
            int compare = ob1.compareTo(ob2);
            if(compare == 0) {
                Comparator<T> tComparator = ownComparator(function);
                return  tComparator.compare(ob1,ob2);
            } else{
                return  compare;
            }
        };
    }
    public static <T, U extends Comparable<? super U>> ComparatorsExample<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (ComparatorsExample<T> & Serializable)
                (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }
}
