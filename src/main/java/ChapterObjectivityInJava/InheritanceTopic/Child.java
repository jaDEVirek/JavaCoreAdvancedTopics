package ChapterObjectivityInJava.InheritanceTopic;

public class Child extends Parent {
    @Override
    public void method1(){System.out.println("child");}
    public static void method2(){ System.out.println("static child");}

    public static int Method1(){
        return 1;
    }
}

class Parent{
   // private void method1(){ System.out.println("parent");}
    public static void method2(){ System.out.println("static parent");}
    public  void method1(){ System.out.println(" parent");}

    public static int Method1(){
        return 0;
    }
    public static void main(String[] args){
        Parent p = new Child();
        p.method1(); //prints out "parent"
        p.method2(); //prints out "static parent"
        System.out.println(Child.Method1());
        System.out.println(Parent.Method1());
        System.out.println(  p.Method1());
        System.out.println(  p.Method1());


    }
}

