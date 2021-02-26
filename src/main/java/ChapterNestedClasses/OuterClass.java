package ChapterNestedClasses;

public class OuterClass {
    private String LocalString;

    public static class InnerClass2 {

        public void myMethod() {
            OuterClass outerClass = new OuterClass();
            System.out.println(outerClass.LocalString);
            System.out.println(outerClass instanceof OuterClass);

        }
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

        System.out.println(inner34.getClass()
                .toString());
    }

    private void tryInstantiate() {
        InnerClass2 inner = new InnerClass2();
        instantiate();
        InnerClass2 in2 = new OuterClass().instantiate();
        OuterClass.InnerClass2 in3 = new InnerClass2();
        System.out.println(in2);
    }
}

