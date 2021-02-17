package ChapterJDBC.JsonMaping;

import java.util.List;

/**
 *
 *
 */
public class GenericsWildcards {


    public static void main(String[] args) {
        GenericType<String> abc = new GenericType<>("Abc");
        abc.set("bbc");

        GenericType genericType = new GenericType("1"); // raw
        genericType.set("Objects");
        genericType.set(11);
        genericType.addToList("11");
        genericType.addToList(5);
        genericType.getTypeList().forEach(
                t-> System.out.println(t));
        System.out.println(genericType.get());
    }

    public static double sum(List<? extends Number> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void printData(List<?> list){
        for(Object obj : list){
            System.out.print(obj + "::");
        }
    }

    //Java Generic Method
    public static <T> boolean isEqual(GenericType<T> g1, GenericType<T> g2){
        return g1.get().equals(g2.get());
    }



}
