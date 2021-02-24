package ChapterJDBC.JsonMaping;

import java.util.ArrayList;
import java.util.List;

public class GenericType<T> {

    private T t;
    private List<T> typeList = new ArrayList<>();

    public GenericType() {
    }

    public GenericType(T arg) {
            this.t=arg;
    }

    public T getTObject(){
        return this.t;
    }

    public GenericType<T> setTObject(T t1){
        if(this.t == null)
        this.t=t1;
        return this;
    }

    public List<T> getTypeList() {
        return typeList;
    }

    public GenericType<T> setTypeList(List<T> typeList) {
        this.typeList = typeList;
        return this;
    }

    public void addToList(T s) {
        this.typeList.add(s);
    }

    public GenericType<T> getThis(){
        return this;
    }

    public static String showStringStatic(){
        System.out.println("From static");
        return "this-static";
    }
}
