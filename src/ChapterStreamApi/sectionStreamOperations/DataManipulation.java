package ChapterStreamApi.sectionStreamOperations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataManipulation {

    static final String teamsDataPath = "src\\ChapterStreamApi\\data\\";

    public static void main(String[] args) throws IOException {
        Stream<String> dataAsStream = getDataAsStream("basic1");

        //Stream<String[]> stream = dataAsStream.map(x -> x.split(","));
      //stream.flatMap(Collection::stream).map(x->x.toString());


        //  Set<String> collect = dataAsStream.collect(Collectors.toSet());

       // System.out.println(collect.toString() );
    }

    static Stream<String> getDataAsStream(String fileName) throws IOException {
        return switch(fileName){
            case "teams", "basic1" -> Files.lines(Paths.get(teamsDataPath+fileName+".txt"));
            default -> throw new IllegalArgumentException("Unexpected value: " + fileName);
        };
    }

}
