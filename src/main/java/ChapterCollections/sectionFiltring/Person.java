package ChapterCollections.sectionFiltring;

import ChapterJDBC.JsonMaping.Vehicle;

import java.util.Calendar;
import java.util.Collection;

public class Person {

    private Long id;
    private Collection<Vehicle> vehicleList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Collection<Vehicle> getListOfOwnedVehicles() {
        return this.vehicleList;
    }
}
