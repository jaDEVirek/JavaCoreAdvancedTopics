package ChapterObjectivityInJava.InheritanceTopic;

public  class AbstractPerson {
    private String name;
    private String gender;

    /*
     We can have a constructor for abstract class. Used on super - call.
     */
    public AbstractPerson(String nm, String gen) {
        this.name = nm;
        this.gender = gen;
    }

//    abstract method
    //

    @Override
    public String toString() {
        return "Name=" + this.name + "::Gender=" + this.gender;
    }

    private void changeName(String newName) {
        System.out.println("from here");
        this.name=newName;
    }
}
