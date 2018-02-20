package com.company;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Created by Cameron Newborn on Feb 3, 2018
 */
public class HangmanRunner {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int maxGuesses = 6;
    private static final Logger LOGGER = Logger.getLogger(HangmanRunner.class.getName());

    /**
     * Basically the main method. Not actually the main method so I can do recursion!
     *
     * Creates a fresh word, iterates over the readInput method, and prints a new prompt after each guess
     */
    public static void run() {
        Word word = new Word(WordBank.Category.COLORS, maxGuesses);
        print(StaticText.introText(word.getBlankWord()));
        while (word.isUnfinished()) {
            //Main loop for getting user input. Will only run while game is not finished
            GuessType guessType = readInput(word, false);
            //Creating prompt text. Prompt depends on the accuracy of the previous guess
            String prompt = "";
            switch (guessType) {
                case CORRECTCHARGUESS:
                    prompt = "That is correct!";
                    break;
                case WRONGCHARGUESS:
                    prompt = "That is incorrect!";
                    break;
                case CORRECTWORDGUESS:
                    prompt = "That is correct!";
                    break;
                case WRONGWORDGUESS:
                    prompt = "That is incorrect!";
                    break;
                case PREVGUESS:
                    prompt = "You already guessed that.";
                    break;
            }
            if (!guessType.equals(GuessType.CORRECTWORDGUESS)) {
                prompt += " Make another guess.";
            }

            //prompt value it is put into the prompt() method which adds the hangman art and previous guesses
            print(StaticText.prompt(prompt, word, !word.isUnfinished()));
        }
        if (word.isUnfinished() && !word.hasBeenCorrectlyGuessed()) {
            print("Loop broken unexpectedly!");
        }
        endText(word.hasBeenCorrectlyGuessed(), word);
        System.exit(0);
    }

    /**
     * Certifiably 72.2% faster! (than typing System.out.println()... wait)
     * @param string the string... you want to print... does it need clarification?
     */
    private static void print(String string) {
        System.out.println(string);
    }

    /**
     * Tests (hopefully) all conditions of an input and processes it
     * @param word THE. word
     * @return GuessType
     */
    private static GuessType readInput(Word word, boolean warn) {//Reads the input and does all the stuff
        if (warn) print("I don't understand that input. Make a guess or type a command.");
        String input = scanner.nextLine();
        input = input.toLowerCase();
        //Main input checker switch
        switch (getInputType(input)) {
            case CHARGUESS:

                switch (word.guessChar(input.charAt(0))) {
                    case CORRECT:
                        return GuessType.CORRECTCHARGUESS;
                    case INCORRECT:
                        return GuessType.WRONGCHARGUESS;
                    case PREVGUESSED:
                        return GuessType.PREVGUESS;
                    default:
                        return GuessType.OTHER;
                }

            case WORDGUESS:

                switch (word.guessWord(input)) {
                    case CORRECT:
                        return GuessType.CORRECTWORDGUESS;
                    case INCORRECT:
                        return GuessType.WRONGWORDGUESS;
                    case PREVGUESSED:
                        return GuessType.PREVGUESS;
                    default:
                        return GuessType.OTHER;
                }

            case INVALIDCOMMAND:
                print(StaticText.commandsText(true));
                break;
            case INVALIDINPUT:
                return readInput(word, true);
            default:
                return GuessType.OTHER;
        }
        return GuessType.OTHER;
    }

    /**
     * Checks input type
     * @param input User string input
     * @return InputType
     */
    private static InputType getInputType(String input) {
        //Checks for commands
        if (input.contains("/")) {
            if (input.indexOf("/") == 0) {
                if (input.contains("/exit")) {
                    exitConfirm();
                    return InputType.EXITCOMMAND;
                }
                else if (input.contains("/restart")) {
                    restartConfirm();
                    return InputType.RESTARTCOMMAND;
                }
                else if (input.contains("/help")) {
                    print(StaticText.commandsText(false));
                }

            }
            return InputType.INVALIDCOMMAND;
        }
        //Checks for guesses
        if (input.matches(".*[a-z]")) {
            if (input.length() == 1) {
                return InputType.CHARGUESS;
            }
            else if (input.length() > 1) {
                return InputType.WORDGUESS;
            }
            else {
                return InputType.INVALIDINPUT;
            }
        }
        return InputType.INVALIDINPUT;
    }

    /**
     * Gives end message, gives user option to start new game or exit
     * @param winnerWinner
     * @param word
     */
    private static void endText(boolean winnerWinner, Word word) {
        if (winnerWinner) {
            print("Congratulations! You have beaten me! \n" +
                    "Would you like to have another game? Y/N");
            if (checkYN(false)) {
                run();
            }
            else {
                exit();
            }
        }
        else {
            print("Out of guesses! Your word was " + word.getFullWord() + ". \n" +
                    "Would you like to try again? Y/N");
            if (checkYN(false)) {
                run();
            }
            else {
                exit();
            }
        }
    }

    private static void restartConfirm() {
        print("Are you sure you want to start a new HangMan game?");
        if (checkYN(false)) {
            print("\nUser has restarted the program.");
            HangmanRunner.run();
        }
    }

    private static void exitConfirm() {
        print("Are you sure you want to exit? Y/N");
        if (checkYN(false)) {
            print("\nUser has exited the program.");
            exit();
        }
    }

    private static void exit() {
        print("\nThanks for playing!");
        System.exit(1);
    }

    /**
     * Generalized interface for determining a yes/no answer from the user
     * @param warn Whether to advise user that the previous input was not understood
     * @return User's choice
     */
    private static boolean checkYN(boolean warn) {
        if (warn) print("I don't understand that input. Type \"Y\" or \"N\".");
        String input = scanner.nextLine().toLowerCase();
        if (input.length() == 1) {
            if (input.contains("y")) {
                return true;
            }
            else //noinspection SimplifiableIfStatement What does IntelliJ have against readable code?
                if (input.contains("n")) {
                return false;
            }
            else {
                return checkYN(true);
            }
        }
        return false;
    }

    /**
     * Used by the readInput method, differentiates between input types: guess, command, invalid
     */
    private enum InputType {
        CHARGUESS, WORDGUESS,
        EXITCOMMAND, RESTARTCOMMAND,
        INVALIDCOMMAND, INVALIDINPUT,
        OTHER
    }

    /**
     * Also used by readInput method, differentiates between guesses: correct, incorrect, previously used
     */
    private enum GuessType {
        CORRECTCHARGUESS, CORRECTWORDGUESS,
        WRONGCHARGUESS, WRONGWORDGUESS,
        PREVGUESS, OTHER,
    }

}
