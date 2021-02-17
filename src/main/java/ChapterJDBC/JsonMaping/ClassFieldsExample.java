package ChapterJDBC.JsonMaping;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class ClassFieldsExample{


    public static void main(String[] args) throws IllegalAccessException, IOException {
        User user = new User();
        user.setAge(11);
        user.setName("Wiktor");
        Map<String, String> stringStringMap = new ClassFieldsExample().prepareDataFromFields(user);
        System.out.println(stringStringMap.toString());
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(stringStringMap);
        System.out.println("JSON Format: " + s);
    }

    private  Map<String,String> prepareDataFromFields(Object data) throws IllegalAccessException {
        Field[] fields = data.getClass().getDeclaredFields();
        Map<String,String> mapFromFields = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            if(field.get(data) == null ){
            }else mapFromFields.put(field.getName(),field.get(data).toString());
        }
        return mapFromFields;
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

}

