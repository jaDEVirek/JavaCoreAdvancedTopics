package ChapterObjectivityInJava.InheritanceTopic;

public class CheapParcel extends BaseParcel {

    String cheap;
    public void setCheap(String cheap) {
        this.cheap = cheap;
    }

    @Override public String getPrice(String cheap) {
        return super.getPrice(cheap);
    }
}
