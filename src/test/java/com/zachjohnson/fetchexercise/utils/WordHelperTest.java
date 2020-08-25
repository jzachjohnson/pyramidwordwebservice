package com.zachjohnson.fetchexercise.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordHelperTest {

    WordHelper wordHelper = new WordHelper();

    // region isPyramidWord

    @Test
    public void isPyramidWord_returns_true_for_pyramid_word() {
        boolean result = wordHelper.isPyramidWord("banana");
        assertTrue(result);
    }

    @Test
    public void isPyramidWord_returns_true_for_single_char_string() {
        boolean result = wordHelper.isPyramidWord("a");
        assertTrue(result);
    }

    @Test
    public void isPyramidWord_returns_false_for_word_with_gaps_in_letter_count_sequence() {
        boolean result = wordHelper.isPyramidWord("nannna");
        assertFalse(result);
    }

    @Test
    public void isPyramidWord_returns_false_for_word_with_two_letters_with_equal_number_in_word() {
        boolean result = wordHelper.isPyramidWord("bandanna");
        assertFalse(result);
    }

    @Test
    public void isPyramidWord_returns_false_for_words_with_non_alpha_numeric_characters() {
        boolean result = wordHelper.isPyramidWord("#banana");
        assertFalse(result);
    }

    // endregion

    // region isAlphabetic

    @Test
    public void isAlphabetic_returns_true_for_alphabetic_word() {
        boolean result = wordHelper.isAlphabetic("banana");
        assertTrue(result);
    }

    @Test
    public void isAlphabetic_returns_false_for_numbers() {
        boolean result = wordHelper.isAlphabetic("easyas123");
        assertFalse(result);
    }

    @Test
    public void isAlphabetic_returns_false_for_special_chars() {
        boolean result = wordHelper.isAlphabetic("#hashtag");
        assertFalse(result);
    }

    @Test
    public void isAlphabetic_returns_false_for_string_with_spaces() {
        boolean result = wordHelper.isAlphabetic("two words");
        assertFalse(result);
    }

    // endregion

}