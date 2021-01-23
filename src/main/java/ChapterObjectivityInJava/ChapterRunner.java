package ChapterObjectivityInJava;


import ChapterObjectivityInJava.InheritanceTopic.BaseParcel;
import ChapterObjectivityInJava.InheritanceTopic.CheapParcel;

public class ChapterRunner {

    public static void main(String[] args) {
        CheapParcel cheapParcel = new CheapParcel();
        cheapParcel.setCheap("11");
        BaseParcel baseP = cheapParcel;
        System.out.println(baseP.getPrice());

    }
}
