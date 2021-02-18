package ChapterJDBC.JsonMaping;

import java.util.List;

/**
 *
 *
 */
public class GenericsWildcards {


    public static void main(String[] args) {
        GenericType<String> abc = new GenericType<>("tommy");
        abc.setTObject("bbc");

        GenericType genericType = new GenericType("1"); // raw
        genericType.setTObject("Objects");
        genericType.setTObject(11);
        genericType.addToList("11");
        genericType.addToList(5);
        genericType.getTypeList().forEach(
                t-> System.out.println(t));
        System.out.println(genericType.getTObject());

        boolean equal = isEqual(new GenericType().setTObject("tommy").getThis(), abc);
        System.out.println(equal );
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
        return g1.getTObject().equals(g2.getTObject());
    }

//    public static <? extends  Comparable<?>> int comparex(  Comparable<?> t1, Comparable<?> ex){
//       // t1.compareTo(ex);
//        return (int) t1.compareTo(ex);
//    }

}
