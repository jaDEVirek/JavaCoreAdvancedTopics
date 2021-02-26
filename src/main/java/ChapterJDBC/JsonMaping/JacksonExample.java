package ChapterJDBC.JsonMaping;

import com.google.gson.JsonObject;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonExample {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        GenericsWildcards.sum(List.of(1,2,3));
        //For testing
        User user = createDummyUser();
        //Convert object to JSON string
        String jsonInString = mapper.writeValueAsString(user);
        System.out.println(jsonInString);
        // USING GSON and object
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("lista", createDummyUser().getMessages()
                .toString());
        jsonObject.addProperty("Name", "WiktorName");
        jsonObject.addProperty("SomeNull", "null");

        System.out.println("Manipulation\n");
        JsonObject jsonObject1 = GsonManipulation.removeNullValuesFromJson(jsonObject);
        JsonObject jsonObject2 = GsonManipulation.changeNullValueToEmptyFromEntry(jsonObject);
        System.out.println(jsonObject1);
        System.out.println(jsonObject2);

        System.out.println();

    }

    private static User createDummyUser() {
        User user = new User();
        user.setName("Wiktor");
        user.setAge(25);
        List<String> msg = new ArrayList<>();
        msg.add("Basic Massage ");
        msg.add("Hello jackson");
        msg.add("Third massage");
        user.setMessages(msg);
        return user;
    }
}
