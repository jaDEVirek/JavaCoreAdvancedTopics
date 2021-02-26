package ChapterObjectivityInJava;


import ChapterObjectivityInJava.InheritanceTopic.AbstractPerson;
import ChapterObjectivityInJava.InheritanceTopic.BaseParcel;
import ChapterObjectivityInJava.InheritanceTopic.CheapParcel;
import javassist.runtime.Inner;

public class ChapterRunner extends AbstractPerson {


    public ChapterRunner(String nm, String gen) {
        super(nm, gen);
    }

    public static void main(String[] args) {
        CheapParcel cheapParcel = new CheapParcel();
         BaseParcel baseParcel = new BaseParcel();
         System.out.println(baseParcel.getPrice(  cheapParcel.getPrice("11")));
        AbstractPerson abTest = new ChapterRunner("hno","hno");

//        AbstractPerson ab = new AbstractPerson("Workon","Flow :)") {
//            @Override
//            public void work() {
//                System.out.println(this.toString());
//            }
//        };
      //   abTest.ch("Xd");
    }

    public void changeName(String arg){
        System.out.println("from ! here");
    }
}

 class InnerRunner extends AbstractPerson{

    public InnerRunner(String nm, String gen) {
        super(nm, gen);
    }

//    @Override
//    public void work() {
//        System.out.println("Test");
//        this.changeName("Change name from baseClass");
//    }
    // we cant ovveride but can hide class

}
