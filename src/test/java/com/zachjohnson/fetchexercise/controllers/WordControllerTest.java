package com.zachjohnson.fetchexercise.controllers;

import com.zachjohnson.fetchexercise.utils.WordHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class WordControllerTest {

    private static final WordHelper wordHelper = mock(WordHelper.class);
    private static final WordController controller = new WordController(wordHelper);

    @BeforeEach
    public void init() {
        when(wordHelper.isPyramidWord(anyString())).thenReturn(true);
        when(wordHelper.isAlphabetic(anyString())).thenReturn(true);
    }

    // region isPyramidWord

    @Test
    public void isPyramidWord_calls_word_helper_method() {
        String word = "banana";
        controller.isPyramidWord(word);
        verify(wordHelper).isPyramidWord(word);
    }

    @Test
    public void isPyramidWord_returns_result() {
        ResponseEntity<Boolean> result = controller.isPyramidWord("banana");
        assertTrue(result.getStatusCode().is2xxSuccessful());
        assertTrue(result.getBody());
    }

    @Test
    public void isPyramidWord_rejects_strings_with_multiple_words() {
        ResponseEntity<Boolean> result = controller.isPyramidWord("banana fofanna");
        assertTrue(result.getStatusCode().is4xxClientError());
    }

    @Test
    public void isPyramidWord_rejects_non_alhpanumeric_input() {
        when(wordHelper.isAlphabetic(anyString())).thenReturn(false);
        ResponseEntity<Boolean> result = controller.isPyramidWord("#banana");
        assertTrue(result.getStatusCode().is4xxClientError());
    }

    @Test
    public void isPyramidWord_rejects_null_input() {
        ResponseEntity<Boolean> result = controller.isPyramidWord(null);
        assertTrue(result.getStatusCode().is4xxClientError());
    }

    @Test
    public void isPyramidWord_rejects_empty_input() {
        ResponseEntity<Boolean> result = controller.isPyramidWord("");
        assertTrue(result.getStatusCode().is4xxClientError());
    }

    // endregion

}