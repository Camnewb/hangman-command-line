package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordBank {

    private List<String> colorBank;

    public WordBank() {
        this.colorBank = new ArrayList<>();
        this.colorBank.addAll(Arrays.asList("azure", "cyan", "chartreuse", "aqua", "olive", "magenta"));
    }

    public String getRandomWord(Category category) {
        Random random = new Random();
        switch (category) {
            case COLORS:
                return colorBank.get(random.nextInt(colorBank.size()));
        }
        return "";
    }

    public enum Category {COLORS, MOVIE_TITLES, BOOK_TITLES}

}
