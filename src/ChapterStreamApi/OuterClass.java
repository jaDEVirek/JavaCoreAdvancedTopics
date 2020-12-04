package ChapterStreamApi;

public class OuterClass {

    public class InnerClass2 {
    }

    private InnerClass2 instantiate() {
        return new InnerClass2();
    }


    public static void main(String[] args) {
        OuterClass ouer = new OuterClass();
        InnerClass2 instantiate = ouer.instantiate();
        InnerClass2 innerClass2 = new InnerClass2();
        OuterClass.InnerClass2 inner3 = new InnerClass2();
        InnerClass2 inner34 = new OuterClass().instantiate();

        System.out.println(inner34.getClass().toString());
    }
}


