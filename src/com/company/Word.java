package com.company;

import java.util.ArrayList;
import java.util.List;

public class Word {

    private String wordString;
    private List<Character> visibleChars;
    private List<Character> wrongGuessedChars;
    private List<String> wrongGuessedWords;
    private boolean hasBeenCorrectlyGuessed;

    Word(String word) {
        this.wordString = word;
        this.visibleChars = new ArrayList<>();
        this.wrongGuessedChars = new ArrayList<>();
        this.wrongGuessedWords = new ArrayList<>();
        this.hasBeenCorrectlyGuessed = false;
    }

    Word(WordBank.Category category) {
        WordBank wordBank = new WordBank();
        this.wordString = wordBank.getRandomWord(category);
        this.visibleChars = new ArrayList<>();
        this.wrongGuessedChars = new ArrayList<>();
        this.wrongGuessedWords = new ArrayList<>();
        this.hasBeenCorrectlyGuessed = false;
    }

    public String getFullWord() {
        return this.wordString;
    }

    public List<Character> getWrongGuessedChars() {
        return this.wrongGuessedChars;
    }

    public List<String> getWrongGuessedWords() {
        return this.wrongGuessedWords;
    }

    public boolean getHasBeenCorrectlyGuessed() {
        return this.hasBeenCorrectlyGuessed;
    }

    public String getBlankWord() {
        StringBuilder blankWord = new StringBuilder();
        for (int i = 0; i < this.wordString.length(); i++) {
            blankWord.append("_");
        }
        return blankWord.toString();
    }

    public String getGuessedShownWord() {
        StringBuilder shownWord = new StringBuilder();
        for (int i = 0; i < this.wordString.length(); i++) {
            boolean blank = true;//
            for (Character visibleChar : visibleChars) {
                if (this.wordString.substring(i, i + 1).indexOf(visibleChar) != -1) {
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

    /**
     * Method for guessing a character in the word
     * @param guess char guess
     */
    public void guessChar(Character guess) {
        if (this.wordString.indexOf(guess) != -1 && !isAlreadyGuessed(guess)) {
            this.visibleChars.add(guess);
        }
        else {
            this.wrongGuessedChars.add(guess);
        }
    }

    /**
     * Method for guessing the word
     * @param guess String guess
     */
    public void guessWord(String guess) {
        if (this.wordString.equals(guess)) {
            this.hasBeenCorrectlyGuessed = true;
        }
        else {
            this.wrongGuessedWords.add(guess);
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
