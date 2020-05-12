package com.wipro.controller;

import com.wipro.model.JSONData;
import com.wipro.model.MongoDbModel;
import com.wipro.service.JsonParserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonParserController {

    private static final Logger logger = LogManager.getLogger(JsonParserController.class);

    @Autowired
    private JsonParserService jsonParserService;

    @PostMapping("/incoming")
    public ResponseEntity<?> parseJSONData(@RequestBody JSONData jsonData) {

        boolean success = jsonParserService.validateJSONData(jsonData);

        //validate incoming request
        //TODO : To implement the validation logic for the incoming json object
        if (success) {
            logger.info("Successfully parsed the JSON data"+jsonData);
            //save incoming request to mongodb collection
            jsonParserService.saveIncomingJSONData(jsonData);
            //Construct the model to be saved to mongodb
            MongoDbModel mongoDbModel = jsonParserService.constructOutgoingModelData(jsonData);
            //save the outgoing request
            jsonParserService.saveOutgoingModelData(mongoDbModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>("Sorry unable to perform the JSON parsing!!!!", HttpStatus.NOT_FOUND);

    }
}
