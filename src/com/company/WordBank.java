package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordBank {

    private static final List<String> colorBank = Arrays.asList("azure", "cyan", "chartreuse", "aqua", "olive",
            "magenta");

    public static String getRandomWord(Category category) {
        Random random = new Random();
        switch (category) {
            case COLORS:
                return colorBank.get(random.nextInt(colorBank.size()));
        }
        return "";
    }

    public enum Category {COLORS, MOVIE_TITLES, BOOK_TITLES}

}
