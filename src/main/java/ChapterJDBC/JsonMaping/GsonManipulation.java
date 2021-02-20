package ChapterJDBC.JsonMaping;

import com.google.gson.JsonObject;

/**
 *
 */
public class GsonManipulation {

    private GenericType<User> genericUser;

    public static void main(String[] args) {
//        removeNullValuesFromJson();
    }

    private static GsonManipulation initGenericUser(User user){
        GsonManipulation gsonManipulation = new GsonManipulation();
        gsonManipulation.genericUser = new GenericType<>();
        return gsonManipulation;
    }

    // funny CV code
    public static JsonObject removeNullValuesFromJson(JsonObject jsonObject){
        jsonObject.keySet().forEach(t->{
            System.out.println(jsonObject.get(t));
            if(jsonObject.get(t).getAsString().equals( "null")){
                  jsonObject.addProperty(t,"juznieNull");
            }
        });
        return jsonObject;
    }

    public static JsonObject changeNullValueToEmptyFromEntry(JsonObject jsonObject){
        jsonObject.entrySet().forEach( val -> {
            if(val.getValue().getAsString().equals("null")){
                jsonObject.addProperty(val.getKey(),"");
            }
        });
        return jsonObject;
    }

    public static String getSJsonAsStringWithoutNullVal(JsonObject jsonObject){
        return jsonObject.toString()
                .replaceAll("null", "");
    }
}



