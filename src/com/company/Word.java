package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles all actions to do with word guessing
 */
public class Word {

    private String wordString;
    private int maxGuesses;

    private List<Character> visibleChars = new ArrayList<>();
    private List<Character> wrongGuessedChars = new ArrayList<>();
    private List<String> guessedWords = new ArrayList<>();

    private boolean hasBeenCorrectlyGuessed = false;
    private boolean ranOutOfGuesses = false;

    private Word(String word, int maxGuesses) {
        this.wordString = word;
        this.maxGuesses = maxGuesses;
    }

    Word(WordBank.Category category, int maxGuesses) {
        this(WordBank.getRandomWord(category), maxGuesses);
    }

    public String getFullWord() {
        return underline(this.wordString);
    }

    public List<Character> getVisibleChars() {
        return this.visibleChars;
    }

    public List<Character> getWrongGuessedChars() {
        return this.wrongGuessedChars;
    }

    public List<String> getAllGuessedWords() {
        return this.guessedWords;
    }

    public List<String> getWrongGuessedWords() {//Filtered out correct guesses. Not sure this is necessary but whatever
        return this.guessedWords.stream().filter(word -> !word.equals(this.wordString)).collect(Collectors.toList());
    }

    public boolean hasBeenCorrectlyGuessed() {
        return this.hasBeenCorrectlyGuessed;
    }

    public int getGuesses() {
        return this.wrongGuessedChars.size() + getWrongGuessedWords().size();
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
        return underline(shownWord.toString());
    }

    private static String underline(String str) {//Uses voodoo magic to underline text in the command line
        return (char) 27 + "[4m" + str + (char) 27 + "[0m";
    }

    /**
     * Method for guessing a character in the word
     * @param guess char guess
     * @return Whether guess is correct or not
     */
    public GuessResult guessChar(Character guess) {
        //Checks if char has already been guessed, checks for accuracy, and either adds the guess to visibleChars or
        //wrongGuessedChars
        if (isAlreadyGuessed(guess)) {
            return GuessResult.PREVGUESSED;
        }
        if (this.wordString.indexOf(guess) != -1) {
            this.visibleChars.add(guess);
            return GuessResult.CORRECT;
        }
        else {
            this.wrongGuessedChars.add(guess);
            return GuessResult.INCORRECT;
        }
    }

    /**
     * Method for guessing the word
     * @param guess String guess
     * @return Whether guess is correct or not
     */
    public GuessResult guessWord(String guess) {
        //Checks if word has already been guessed, checks for accuracy, and adds the char to visibleChars or wrongGuessedChars
        if (isAlreadyGuessed(guess)) {
            return GuessResult.PREVGUESSED;
        }
        else if (this.wordString.equals(guess)) {
            this.hasBeenCorrectlyGuessed = true;
            this.guessedWords.add(guess);
            return GuessResult.CORRECT;
        }
        else {
            this.guessedWords.add(guess);
            return GuessResult.INCORRECT;
        }
    }

    private boolean isAlreadyGuessed(Character character) {
        for (Character visibleChar : visibleChars) {
            if (visibleChar.equals(character)) {
                return true;
            }
        }
        for (Character wrongChar : wrongGuessedChars) {
            if (wrongChar.equals(character)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAlreadyGuessed(String string) {
        for (String word : guessedWords) {
            if (word.equals(string)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFinished() {//Returns whether or not the user has ran out of guesses or has correctly guessed the word
        this.ranOutOfGuesses = this.wrongGuessedChars.size() + getWrongGuessedWords().size() >= this.maxGuesses;
        if (this.ranOutOfGuesses) return this.ranOutOfGuesses;

        //noinspection SimplifiableIfStatement I WANT MY CODE TO BE READABLE DAMMIT
        if (!getGuessesShownWord().contains("_")) {
            this.hasBeenCorrectlyGuessed = true;
        }
        else {
            this.hasBeenCorrectlyGuessed = this.guessedWords.contains(this.wordString);
        }
        return hasBeenCorrectlyGuessed;
    }

    enum GuessResult {
        CORRECT, INCORRECT,
        PREVGUESSED, INVALID
    }

}
