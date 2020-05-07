package com.wipro.service;

import com.wipro.model.JSONData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JsonParserService {

    private static final Logger logger = LogManager.getLogger(JsonParserService.class);

    //TODO : To define the methods to save the mongodb object
    //private MongoDbDao mongoDbDao;

   /**
     * This method is used to validate the incoming JSON data
     */
    public boolean validateJSONData(JSONData jsonData){
        return true;
    }

    //Find duplicate characters in a given string
    public List<String> findDuplicates(String inputString){
        Map<String, Long> charCount = inputString.chars().mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List duplicateCharacters = charCount.entrySet().stream().filter(value -> {
            if(value.getValue() >=2)
                return true;
            return false;
        }).map(map -> map.getKey()).collect(Collectors.toList());
        return duplicateCharacters;
    }

    //Method to remove white spaces with out using replace function
    public String removeWhiteSpace(String string){
        String leanString = Arrays.stream(string.split(" ")).map(
                s -> s.trim()).collect(Collectors.joining());
        return leanString;
    }

    //Find the largest number in a give integer array
    public int fetchLargestNumber(int[] inputArray){
        return Arrays.stream(inputArray).max().getAsInt();
    }
}
