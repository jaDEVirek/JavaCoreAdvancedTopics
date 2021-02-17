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

    public T get(){
        return this.t;
    }

    public void set(T t1){
        if(this.t == null)
        this.t=t1;
    }

    public List<T> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<T> typeList) {
        this.typeList = typeList;
    }

    public void addToList(T s) {
        this.typeList.add(s);
    }
}
