package com.company;

import java.util.List;

public class StaticText {

    public static String introText(String blankWord) {
        return "\n" +
                "==================================\n" +
                "-------------Hang Man-------------\n" +
                "==================================\n" +
                "\n" +
                "Welcome to hangman! Your word is: \n" +
                blankWord;
    }

    public static String commandsText(boolean warn) {
        return (warn ? "I don't understand that command. Choose one of these:" : "")+
                "\n--==============================-- \n" +
                "        --Commands List--          \n" +
                " /help     : Shows this menu. \n" +
                " /exit     : Exits program. Duh. \n" +
                " /restart  : Starts a new game. \n" +
                "" +
                "\n--==============================-- \n";
    }

    public static String hangMan(int stage) {
        switch (stage) {
            case 6://It's reversed because I'm stupid and lazy
                return "\n" +
                        "==================================\n" +
                        "\n" +
                        "           |---------------------|  \n " +
                        "          |---------------\\-\\-|-|  \n " +
                        "            ||             \\ \\| |  \n " +
                        "            ||              \\ | |  \n " +
                        "            __               \\| |  \n " +
                        "           {__}               | |  \n " +
                        "           _||_               | |  \n " +
                        "          //||\\\\              | |  \n " +
                        "         // || \\\\             | |  \n " +
                        "           //\\\\               | |  \n " +
                        "          //  \\\\              | |  \n " +
                        "         //    \\\\             | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |   ";
            case 5:
                return "\n" +
                        "==================================\n" +
                        "\n" +
                        "           |---------------------|  \n " +
                        "          |---------------\\-\\-|-|  \n " +
                        "            ||             \\ \\| |  \n " +
                        "            ||              \\ | |  \n " +
                        "            __               \\| |  \n " +
                        "           {__}               | |  \n " +
                        "           _||_               | |  \n " +
                        "          //||\\\\              | |  \n " +
                        "         // || \\\\             | |  \n " +
                        "           //                 | |  \n " +
                        "          //                  | |  \n " +
                        "         //                   | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |   ";
            case 4:
                return "\n" +
                        "==================================\n" +
                        "\n" +
                        "           |---------------------|  \n " +
                        "          |---------------\\-\\-|-|  \n " +
                        "            ||             \\ \\| |  \n " +
                        "            ||              \\ | |  \n " +
                        "            __               \\| |  \n " +
                        "           {__}               | |  \n " +
                        "           _||_               | |  \n " +
                        "          //||\\\\              | |  \n " +
                        "         // || \\\\             | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |   ";
            case 3:
                return "\n" +
                        "==================================\n" +
                        "\n" +
                        "           |---------------------|  \n " +
                        "          |---------------\\-\\-|-|  \n " +
                        "            ||             \\ \\| |  \n " +
                        "            ||              \\ | |  \n " +
                        "            __               \\| |  \n " +
                        "           {__}               | |  \n " +
                        "           _||_               | |  \n " +
                        "          //||                | |  \n " +
                        "         // ||                | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |   ";
            case 2:
                return "\n" +
                        "==================================\n" +
                        "\n" +
                        "           |---------------------|  \n " +
                        "          |---------------\\-\\-|-|  \n " +
                        "            ||             \\ \\| |  \n " +
                        "            ||              \\ | |  \n " +
                        "            __               \\| |  \n " +
                        "           {__}               | |  \n " +
                        "           _||_               | |  \n " +
                        "            ||                | |  \n " +
                        "            ||                | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |   ";
            case 1:
                return "\n" +
                        "==================================\n" +
                        "\n" +
                        "           |---------------------|  \n " +
                        "          |---------------\\-\\-|-|  \n " +
                        "            ||             \\ \\| |  \n " +
                        "            ||              \\ | |  \n " +
                        "            __               \\| |  \n " +
                        "           {__}               | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |   ";
            case 0:
                return "\n" +
                        "==================================\n" +
                        "\n" +
                        "           |---------------------|  \n " +
                        "          |---------------\\-\\-|-|  \n " +
                        "            ||             \\ \\| |  \n " +
                        "            ||              \\ | |  \n " +
                        "                             \\| |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |   ";
        }
        return "";
    }

    /**
     * Assembles the text, graphic, and word for every guess
     * @param prompt
     * @param word
     * @param isFinished
     * @return Prompt in string form
     */
    public static String prompt(String prompt, Word word, boolean isFinished) {
        String promptText = hangMan(word.getGuesses()) +
                "\n" +
                "==================================\n";
        StringBuilder wrongGuesses = new StringBuilder();
        for (Character wrongGuessedChar : word.getWrongGuessedChars()) {
            wrongGuesses.append(wrongGuessedChar.toString()).append(", ");
        }
        for (String wrongGuessedWord : word.getWrongGuessedWords()) {
            wrongGuesses.append(wrongGuessedWord).append(", ");
        }
        promptText += "Wrong: " + wrongGuesses + "\n" +
                "----------------------------------\n";

        //Creates a spacer to put the GuessesShownWord near the middle of the graphic
        String spacer = mult(" ", ((34 / 2) - (word.getFullWord().length() / 2)));//34 chars is length of graphic

        promptText += "\n" + spacer + (isFinished ? word.getFullWord() : word.getGuessesShownWord()) + "\n\n" + prompt + "\n";

        return promptText;
    }

    /**
     * Works exactly like you expect "Hello" * 3 to work: concatenation in another dimension!
     * @param str string for multiplying
     * @param times times to multiply
     * @return String multiplied by times
     */
    private static String mult(String str, int times) {//#ThereShouldAlreadyBeAMethodForThisCmonOracle
        if (times < 0) {
            return str;
        }
        StringBuilder strBuilder = new StringBuilder(str);
        for (int i = 0; i < times; i++) {
            strBuilder.append(str);
        }
        return strBuilder.toString();
    }

}
