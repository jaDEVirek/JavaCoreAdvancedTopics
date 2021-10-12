package ChapterNestedClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OuterClass {
    private String LocalString;

   static class InnerClass2 {
       String localString2;
        public void myMethod() {
            OuterClass outerClass = new OuterClass();
            System.out.println(outerClass.LocalString);
            System.out.println(outerClass instanceof OuterClass);

        }
    }

    private InnerClass2 instantiate() {
        return new InnerClass2();
    }


    public static void main(String[] args) {
        OuterClass ouer = new OuterClass();
        InnerClass2 instantiate = ouer.instantiate();
        InnerClass2 innerClass2 = new InnerClass2();
        OuterClass.InnerClass2 inner3 = new InnerClass2();
        InnerClass2 inner34 = new OuterClass().instantiate();

        System.out.println(inner34.getClass()
                .toString());

        List<Integer> list4 = List.of(7, 8, 9);
        List<Integer> integers = new ArrayList<>(list4);
        integers.add(5);
        integers.stream().filter(x-> x%2 != 0).collect(Collectors.toList()).forEach(System.out::println);
        integers.set(2,11);
        String[] array = {"a","b","c","d","e"};
        array[0]= "nowy";
        List<String> strings = Arrays.asList(array);
        strings.set(1,"bbb");
        strings.add("new1");
        List<Integer> integers1 = List.of(1, 23, 5, 7, 6);
//        integers1.set(3,11);
        System.out.println(array.toString());
   }

    private void tryInstantiate() {
        InnerClass2 inner = new InnerClass2();
        instantiate();
        InnerClass2 in2 = new OuterClass().instantiate();
        OuterClass.InnerClass2 in3 = new InnerClass2();
        System.out.println(in2);
    }
}

