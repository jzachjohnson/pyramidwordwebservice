package com.zachjohnson.fetchexercise.controllers;

import com.zachjohnson.fetchexercise.utils.WordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@RestController
public class WordController {

    private final WordHelper wordHelper;

    @Autowired
    public WordController(WordHelper wordHelper) {
        this.wordHelper = wordHelper;
    }

    @PostMapping("/ispyramid")
    public ResponseEntity<Boolean> isPyramidWord(@Valid @RequestBody() String word) {
        if (isEmpty(word) || !wordHelper.isAlphabetic(word) || word.contains(" ")) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(wordHelper.isPyramidWord(word));
        }
    }

}
