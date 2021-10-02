//package ChapterRekordJDK14;
//
//
//import ChapterJDBC.JsonMaping.User;
//import ChapterNestedClasses.OuterClass;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//
//public class RecordExample {
//
//    PersonRecord ownRecord;
//
//    public static void main(String args[]) {
//        PersonRecord sample = new PersonRecord("FirstRecord","Kraków, Poland.");
//       givenUsingTheJdk_whenUnmodifiableListIsCreated_thenNotModifiable();
//        OuterClass outer = new OuterClass();
//    }
//
//    /**
//     * To minimalize border plate code
//     */
//    record PersonRecord(String name, String address) {
//        private static final List<String> gender = new ArrayList<>();
//        public PersonRecord {
//            if(name.endsWith("a")){
//                gender.add("woman");
//            }else{
//                gender.add("man");
//            }
//        }
//    }
//
//    /**
//     * Pattern Matching for instanceof (Preview)
//     * @param object
//     */
//    public void patternMatching(Object object){
//                if(object instanceof String str){
//                    System.out.println(str);
//                }
//            if (object instanceof User) {
//                User user = (User) object;
//                System.out.println(user);
//            }
//        }
//
//    public static void givenUsingTheJdk_whenUnmodifiableListIsCreated_thenNotModifiable() {
//        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
//
//    }
//
//}
//
//
//
