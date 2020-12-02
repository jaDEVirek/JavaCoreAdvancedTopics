package ChapterCollections.sectionFiltring;

public class Person {

    private String fName;
    private String sName;

    @Override public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", sName='" + sName + '\'' +
                '}';
    }

    public Person(String fName, String sName) {
        this.fName = fName;
        this.sName = sName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
