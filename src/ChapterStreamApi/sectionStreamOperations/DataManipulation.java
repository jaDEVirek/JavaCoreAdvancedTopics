package ChapterStreamApi.sectionStreamOperations;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataManipulation {

    static final String teamsDataPath = "src\\ChapterStreamApi\\data\\";

    public static void main(String[] args) throws IOException {
        Stream<String> teamsAsStream = getDataAsStream("teams");


        Stream<String[]> splitedData = teamsAsStream.map(x -> x.split(","));

        ArrayList<String> collectedStrings = splitedData.flatMap(Arrays::stream)
                .map(x -> x.split(","))
                .flatMap(Arrays::stream)
                .collect(Collectors.toCollection(ArrayList::new));

        Stream<String> mapedObjects = getDataAsStream("basic1").map(Object::toString);

        List<String> listOfSlipted = mapedObjects.map(t -> t.split(","))
                .flatMap(Arrays::stream)
                .map(Object::toString).collect(Collectors.toList());
        System.out.println(listOfSlipted.toString());
    }

    static Stream<String> getDataAsStream( String fileName) throws IOException {
        return switch(fileName){
            case "teams", "basic1" -> Files.lines(Paths.get(teamsDataPath+fileName+".txt"));
            default -> throw new IllegalArgumentException("Unexpected value: " + fileName);
        };
    }

}
