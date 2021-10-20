package ChapterStreamApi.sectionStreamOperations;

import ChapterCollections.sectionFiltring.Person;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;

interface ComparatorsExample<T> extends Comparator<T> {

    static void main(String[] args) {
        Person person = new Person("Wiktor", "Reliso");
        Person person2 = new Person("Mick", "Jagger");
        Person person3 = new Person("Jackson", "Jermaine");
        Person person4 = new Person("Jackson", "Michael");
        Person person5 = new Person("Rod", "Stewart");
        List<Person> people = Arrays.asList(person5,null, person4);

        ComparatorsExample<Person> cmp = ownComparator(Person::getfName)
                .thenOwnComparing(Person::getsName);

        ComparatorsExample<Person> nullComparator = nullLast(cmp);
        Collections.sort(people,nullComparator);
        people.forEach(System.out::println);
    }

    static void comparatorUsingJDK8() {
        //nulls pointers will be checked ! is good idea
        Comparator<Person> cmp = Comparator.comparing(Person::getfName)
                .thenComparing(Person::getsName)
                .thenComparing(Person::getId);
//        ComparatorsExample comparatorsExample = new ComparatorsExample();
//        comparatorsExample.ownComparator(Person::getfName)
//                .thenOwnComparing(Person::getsName);
        // bad example
        Comparator<Person> cmp2 = new Comparator<Person>() {
            @Override public int compare(Person o1, Person o2) {
                int cmp = o1.getsName()
                        .compareTo(o2.getsName());
                if (cmp == 0) {
                    cmp = o1.getfName()
                            .compareTo(o2.getfName());
                    if (cmp == 0) {
                        return Long.compare(o1.getId(), o2.getId());
                    } else
                        return cmp;
                }
                return cmp;
            }
        };
    }

    static <T, R extends Comparable<? super R>> ComparatorsExample<T> ownComparator(Function<? super T, R> function) {
        Objects.requireNonNull(function);
        return (ob1, ob2) -> {
            R apply = function.apply(ob1);
            R apply2 = function.apply(ob2);
            return apply.compareTo(apply2);
        };
    }

    static <T, U extends Comparable<? super U>> ComparatorsExample<T> comparing(
            Function<? super T, ? extends U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (ComparatorsExample<T> & Serializable)
                (c1, c2) -> keyExtractor.apply(c1)
                        .compareTo(keyExtractor.apply(c2));
    }

    default <R extends Comparable<? super R>> ComparatorsExample<T> thenOwnComparing(
            Function<T, R> function) {
        Objects.requireNonNull(function);

        return (ob1, ob2) -> {
            int compare = this.compare(ob1, ob2);
            if (compare == 0) {
                ComparatorsExample<T> tComparator = ownComparator(function);
                return tComparator.compare(ob1, ob2);
            } else {
                return compare;
            }
        };
    }

    int compare(T o1, T o2);

    static <T> ComparatorsExample<T> nullLast(Comparator<T> comparator) {
        return (t1, t2) -> {
            if (t1 == t2) {
                return 0;
            } else if(t1 == null) {
                    return 1;
            }else if(t2 ==null ){
                    return -1;
            }else{
                return comparator.compare(t1,t2);
            }
        };
    }

    default ComparatorsExample<T> reverse(){
        return (T t1,T t2 )->
            this.compare(t2,t1);
         // dont use minus !
    }
}
