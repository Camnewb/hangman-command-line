package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Cameron Newborn on Feb 3, 2018
 */
public class HangmanRunner {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Basically the main method. Not actually the main method so I can do recursion! Or maybe it wasn't necessary... WHO CARES ANYMORE?!
     */
    public static void run() {
        WordBank wordBank = new WordBank();
        Word word = new Word(wordBank.getRandomWord(WordBank.Category.COLORS));

        for (int stage = 6; stage >= 0; stage--) {
            readInput(word, false);
        }

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
     */
    private static void readInput(Word word, boolean warn) {//Reads the input and does all the stuff
        if (warn) print("I don't understand that input. What kind of nonsense did you just type?!");
        String input = scanner.nextLine();
        input = input.toLowerCase();

        switch (getInputType(input)) {
            case CHARGUESS:
                if (charGuessCheck(word, input)) {
                    //do stuff
                }
                break;
            case WORDGUESS:
                if (wordGuessCheck(word, input)) {
                    //do other stuff
                }
                break;
            default:
                print("Ok, that isn't even possible. How did you... you know what? Nevermind. I give up. \n Nope. -Cam");
                System.exit(-12345125);
        }
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
            return InputType.INVALIDINPUT;
        }
        //Checks for guesses


        return InputType.INVALIDINPUT;
    }

    /**
     * Checks if char guess is correct
     * @param word THE. word
     * @param guess String guess input, assuming it is 1 char long
     * @return Guess is Correct/Incorrect, or True/False
     */
    private static boolean charGuessCheck(Word word, String guess) {
        return false;
    }

    /**
     * Checks if word guess is correct
     * @param word THE. word class
     * @param guess String guess input, assuming it is longer than 1 char
     * @return Guess is Correct/Incorrect, or True/False
     */
    private static boolean wordGuessCheck(Word word, String guess) {
        return false;
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

    private enum InputType {//Used by the readInput methods and most methods used by it
        CHARGUESS, WORDGUESS,
        EXITCOMMAND, RESTARTCOMMAND,
        INVALIDGUESS, INVALIDINPUT,
        OTHER
    }

}
