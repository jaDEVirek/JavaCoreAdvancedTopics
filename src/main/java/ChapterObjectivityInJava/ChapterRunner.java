package ChapterObjectivityInJava;


import ChapterObjectivityInJava.InheritanceTopic.BaseParcel;
import ChapterObjectivityInJava.InheritanceTopic.CheapParcel;

public class ChapterRunner {

    public static void main(String[] args) {
        CheapParcel cheapParcel = new CheapParcel();
         BaseParcel baseParcel = new BaseParcel();
        System.out.println(baseParcel.getPrice(  cheapParcel.getPrice("11")));
    }


}
