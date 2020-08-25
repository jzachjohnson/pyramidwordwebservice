package com.zachjohnson.fetchexercise.utils;

import org.springframework.context.annotation.Bean;

import java.util.*;

public class WordHelper {

    public boolean isPyramidWord(String word) {
        Map<Character, Integer> letterCountMap = new HashMap<>();
        if (isAlphabetic(word)) {
            for (Character x : word.toCharArray()) {
                if (letterCountMap.containsKey(x)) {
                    Integer currentLetterCount = letterCountMap.get(x);
                    letterCountMap.replace(x,currentLetterCount+1);
                } else {
                    letterCountMap.put(x, 1);
                }
            }
            List<Integer> letterCounts = new ArrayList<>(letterCountMap.values());
            Collections.sort(letterCounts);
            Integer previous = null;
            for (Integer current : letterCounts) {
                if (previous!=null) {
                    if (current-1 != previous) return false;
                }
                previous = current;
            }
            return true;
        } else return false;
    }

    public boolean isAlphabetic(String word) {
        for (char x : word.toCharArray()) {
            if (!Character.isLetter(x)) return false;
        }
        return true;
    }

}
