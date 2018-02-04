package com.company;

import java.util.ArrayList;
import java.util.List;

public class Word {

    private String string;
    private List<Character> visibleChars;
    private List<Character> wrongGuessedChars;

    public Word(String word) {
        this.string = word;
        this.visibleChars = new ArrayList<>();
        this.wrongGuessedChars = new ArrayList<>();
    }

    public String getFullWord() {
        return this.string;
    }

    public List<Character> getWrongGuessedChars() {
        return wrongGuessedChars;
    }

    public String getBlankWord() {
        StringBuilder blankWord = new StringBuilder();
        for (int i = 0; i < this.string.length(); i++) {
            blankWord.append("_");
        }
        return blankWord.toString();
    }

    public String getGuessedShownWord() {
        StringBuilder shownWord = new StringBuilder();
        for (int i = 0; i < this.string.length(); i++) {
            boolean blank = true;//
            for (Character visibleChar : visibleChars) {
                if (this.string.substring(i, i + 1).indexOf(visibleChar) != -1) {
                    shownWord.append(visibleChar);
                    blank = false;
                }

            }
            if (blank) {
                shownWord.append("_");
            }
        }
        return shownWord.toString();
    }

    public void guessChar(Character guess) {
        if (this.string.indexOf(guess) != -1 && !isAlreadyGuessed(guess)) {
            this.visibleChars.add(guess);
        }
        else {
            this.wrongGuessedChars.add(guess);
        }
    }

    public boolean isAlreadyGuessed(Character character) {
        for (Character visibleChar : visibleChars) {
            if (visibleChar.equals(character)) {
                return true;
            }
        }
        return false;
    }

}
