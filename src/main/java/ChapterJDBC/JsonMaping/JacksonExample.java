package ChapterJDBC.JsonMaping;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JacksonExample {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        //For testing
        User user = createDummyUser();
        //Convert object to JSON string
        String jsonInString = mapper.writeValueAsString(user);
        System.out.println(jsonInString);

        Field[] fields = user.getClass()
                .getDeclaredFields();
    }

    private static User createDummyUser() {

        User user = new User();

        user.setName("Wiktor");
        user.setAge(25);

        List<String> msg = new ArrayList<>();
        msg.add("hello jackson 1");
        msg.add("hello jackson 2");
        msg.add("hello jackson 3");

        user.setMessages(msg);

        return user;
    }
}
