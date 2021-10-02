package ChapterStreamApi.sectionLambdas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaDemo {

    static List<Jobs> dataJobs = new ArrayList<>() {
        {
            add(new Jobs("Teach Lead"));
            add(new Jobs("Experience Android Developer"));
            add(new Jobs("Platform engineer"));
            add(new Jobs("Java developer"));
            add(new Jobs("DevOps Engineer-Splunk"));
            add(new Jobs("Senior Cloud Software Engineer"));
            add(new Jobs("Big Data Engineer"));
            add(new Jobs("Site Reliability Engineer"));
            add(new Jobs("Sr  Data Engineer"));
            add(new Jobs("Senior Backend Engineer"));
            add(new Jobs("Team-Lead Developer"));
            add(new Jobs("Software Engineer"));
            add(new Jobs("Seeking Full-Time"));
            add(new Jobs("Senior Research"));
            add(new Jobs("Principal Software Engineer"));
            add(new Jobs("SAP Application Expert FI/CO"));
        }
    };

    public static void main(String[] args) {
        Object o = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        List<Object> string = List.of(o, o2, o3, "string");

        List<? super String> superString= string;
        System.out.println(superString.get(1));
//        superString.add("test");

    }
}
