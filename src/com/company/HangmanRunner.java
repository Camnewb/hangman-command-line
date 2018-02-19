package com.company;

import java.util.Scanner;

/**
 * Created by Cameron Newborn on Feb 3, 2018
 */
public class HangmanRunner {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int maxGuesses = 6;

    /**
     * Basically the main method. Not actually the main method so I can do recursion! Or maybe it wasn't necessary... WHO CARES ANYMORE?!
     */
    public static void run() {
        Word word = new Word(WordBank.Category.COLORS);

        print(StaticText.introText(word.getBlankWord()));
        for(int stage = 0; !word.isFinished() && stage <= maxGuesses; stage++) {
            GuessType guessType = readInput(word, false);
            if (guessType.equals(GuessType.OTHER)) {
                stage--;
            }
            else if (guessType.equals(GuessType.CORRECTWORDGUESS)) {
                break;
            }
            else {
                print(StaticText.prompt(guessType.equals(GuessType.WRONGCHARGUESS) || guessType.equals(GuessType.WRONGWORDGUESS), //Returns the prompt based on whether the guess is correct
                        6 - stage, word.getGuessesShownWord(), word.getWrongGuessedChars(), word.getWrongGuessedWords()));
                if (guessType.equals(GuessType.CORRECTCHARGUESS)) {
                    stage--;
                }
            }
        }
        print("You did it! Don't expect a medal or anything...");
        System.exit(80085);
    }

    /**
     * Certifiably 72.2% faster! (than typing System.out.println()... wait, shit)
     * @param string the string... you want to print... does it need clarification?
     */
    private static void print(String string) {
        System.out.println(string);
    }

    /**
     * Tests (hopefully) all conditions of an input and processes it
     * @param word THE. word
     * @return Whether a guess was made or not
     */
    private static GuessType readInput(Word word, boolean warn) {//Reads the input and does all the stuff
        if (warn) print("I don't understand that input. What kind of nonsense did you just type?!");
        String input = scanner.nextLine();
        input = input.toLowerCase();
        boolean correct;

        switch (getInputType(input)) {
            case CHARGUESS:
                correct = charGuessCheck(word, input);
                return correct ? GuessType.CORRECTCHARGUESS : GuessType.WRONGCHARGUESS;
            case WORDGUESS:
                correct = wordGuessCheck(word, input);
                return correct ? GuessType.CORRECTWORDGUESS : GuessType.WRONGWORDGUESS;

            case INVALIDCOMMAND:
                print("I don't understand that command. Choose one of these:" +
                        "\n--==============================-- \n" +
                        "        --Commands List--          \n" +
                        " /exit     : Exits program. Duh. \n" +
                        " /restart  : Starts a new game. \n" +
                        "" +
                        "\n--==============================-- \n");
                break;
            default:
                return GuessType.OTHER;
        }
        return GuessType.OTHER;
    }

    /**
     * Checks input type
     * @param input User string input
     * @return The input type
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
                    print("\n--==============================-- \n" +
                            "        --Commands List--          \n" +
                            " /exit     : Exits program. Duh. \n" +
                            " /restart  : Starts a new game. \n" +
                            "" +
                            "\n--==============================-- \n");
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
     * Checks if char guess is correct
     * @param word THE. word
     * @param guess String guess input, assuming it is 1 char long
     * @return Guess is Correct/Incorrect, or True/False
     */
    private static boolean charGuessCheck(Word word, String guess) {
        return word.guessChar(guess.charAt(0));
    }

    /**
     * Checks if word guess is correct
     * @param word THE. word class
     * @param guess String guess input, assuming it is longer than 1 char
     * @return Guess is Correct/Incorrect, or True/False
     */
    private static boolean wordGuessCheck(Word word, String guess) {
        return word.guessWord(guess);
    }

    private static void restartConfirm() {
        print("Are you sure you want to start a new HangMan game?");
        if (checkYN(false)) {
            print("\n User has restarted the program.");
            HangmanRunner.run();
        }
    }

    private static void exitConfirm() {
        print("Are you sure you want to exit? Y/N");
        if (checkYN(false)) {
            print("\n User has exited the program.");
            System.exit(1);
        }
    }

    private static boolean checkYN(boolean warn) {
        if (warn) print("I don't understand that input. Type \"Y\" or \"N.\"");
        String input = scanner.nextLine().toLowerCase();
        if (input.length() == 1) {
            if (input.contains("y")) {
                return true;
            }
            else if (input.contains("n")) {
                return false;
            }
            else {
                return checkYN(true);
            }
        }
        return false;
    }

    private enum InputType {//Used by the readInput method
        CHARGUESS, WORDGUESS,
        EXITCOMMAND, RESTARTCOMMAND,
        INVALIDGUESS, INVALIDCOMMAND, INVALIDINPUT,
        OTHER
    }

    private enum GuessType {//Also used by readInput method
        CORRECTCHARGUESS, CORRECTWORDGUESS,
        WRONGCHARGUESS, WRONGWORDGUESS,
        OTHER,
    }

}
