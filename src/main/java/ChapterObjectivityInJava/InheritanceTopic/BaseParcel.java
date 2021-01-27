package ChapterObjectivityInJava.InheritanceTopic;



public class BaseParcel {
    private String size;
    private String price;

    public String getPrice(String pm){
        return price==null ? pm : price ;
    }

}
