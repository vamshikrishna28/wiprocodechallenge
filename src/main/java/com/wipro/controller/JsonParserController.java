package com.wipro.controller;

import com.wipro.model.JSONData;
import com.wipro.service.JsonParserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonParserController {

    private static final Logger logger = LogManager.getLogger(JsonParserController.class);

    @Autowired
    private JsonParserService jsonParserService;

    @PostMapping("/incoming")
    public ResponseEntity<?> parseJSONData(@RequestBody JSONData jsonData) {
        //Logging values just to test, we don't need this when we implement the DAO layer to save to MongoDb
        int largestNumber = jsonParserService.fetchLargestNumber(jsonData.getNumbersMeetNumbers());
        logger.info("Largest Number: "+largestNumber);

        String stringWithoutSpaces = jsonParserService.removeWhiteSpace(jsonData.getWhiteSpacesGalore());
        logger.info("String with out spaces: "+stringWithoutSpaces);

        List<String> duplicatesCharList = jsonParserService.findDuplicates(jsonData.getFindDuplicates());
        logger.info("Duplicate characters: "+duplicatesCharList);

        boolean success = jsonParserService.validateJSONData(jsonData);

        //TODO : To implement the validation logic for the incoming json object
        if (success) {
            logger.info("Successfully parsed the JSON data"+jsonData);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>("Sorry unable to perform the JSON parsing!!!!", HttpStatus.NOT_FOUND);
    }
}
