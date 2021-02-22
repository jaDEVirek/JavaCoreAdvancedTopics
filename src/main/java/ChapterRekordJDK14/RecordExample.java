package ChapterRekordJDK14;


import java.util.ArrayList;
import java.util.List;

public class RecordExample {


    public static void main(String args) {
        PersonRecord sample = new PersonRecord("FirstRecord","Kraków, Poland.");

    }

    /**
     * To minimalize border plate code
     */
    record PersonRecord(String name, String address) {
        private static List<String> gender = new ArrayList<>();

        public PersonRecord {
            if(name.endsWith("a")){
                gender.add("woman");
            }else{
                gender.add("man");
            }
        }
    }


}



