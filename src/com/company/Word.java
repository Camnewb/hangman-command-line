package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles all actions to do with word guessing
 */
public class Word {

    private String wordString;
    private List<Character> visibleChars;
    private List<Character> wrongGuessedChars;
    private List<String> wrongGuessedWords;
    private boolean hasBeenCorrectlyGuessed;
    private boolean isFinished = false;

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

    /**
     * Assembles the classic hangman word with underscores
     * replacing the the unknown letters. For example,
     * if the word is "argonian" a possible return would
     * be "ar__n_an" with chars a, r, and n already guessed.
     * @return The assembled hangman word
     */
    public String getGuessesShownWord() {
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
     * @return Whether guess is correct or not
     */
    public boolean guessChar(Character guess) {
        if (this.wordString.indexOf(guess) != -1 && !isAlreadyGuessed(guess)) {
            this.visibleChars.add(guess);
            return true;
        }
        else {
            this.wrongGuessedChars.add(guess);
            if (this.wrongGuessedChars.size() + this.wrongGuessedWords.size() >= 6) {
                this.isFinished = true;
            }
            return false;
        }
    }

    /**
     * Method for guessing the word
     * @param guess String guess
     * @return Whether guess is correct or not
     */
    public boolean guessWord(String guess) {
        if (this.wordString.equals(guess)) {
            this.hasBeenCorrectlyGuessed = true;
            return true;
        }
        else {
            this.wrongGuessedWords.add(guess);
            if (this.wrongGuessedChars.size() + this.wrongGuessedWords.size() >= 6) {
                this.isFinished = true;
            }
            return false;
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

    public boolean isFinished() {
        if (!this.isFinished) {
            this.isFinished = !getGuessesShownWord().contains("_");
        }
        return this.isFinished;
    }

}
