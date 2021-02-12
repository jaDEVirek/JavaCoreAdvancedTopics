package ChapterJDBC.JsonMaping;

import java.util.List;

public class User {

    private String name;
    private int age;
    private List<String> messages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='")
                .append(name)
                .append('\'');
        sb.append(", age=")
                .append(age);
        sb.append(", messages=")
                .append(messages);
        sb.append('}');
        return sb.toString();
    }
}
