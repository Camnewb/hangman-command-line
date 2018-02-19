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

    public static String hangMan(int stage) {
        switch (stage) {
            case 0:
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
                        "           _||_               | |  \n " +
                        "          //||\\\\              | |  \n " +
                        "         // || \\\\             | |  \n " +
                        "           //                 | |  \n " +
                        "          //                  | |  \n " +
                        "         //                   | |  \n " +
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
                        "            ||                | |  \n " +
                        "            ||                | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
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
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |  \n " +
                        "                              | |   ";
            case 6:
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

    public static String prompt(boolean isWrong, int stage, String guessedCharWord, List<Character> wrongGuessedChars, List<String> wrongGuessedWords) {
        String promptText = hangMan(stage) +
                "\n" +
                "==================================\n";
        StringBuilder wrongChars = new StringBuilder();
        for (Character wrongGuessedChar : wrongGuessedChars) {
            wrongChars.append(wrongGuessedChar.toString()).append(", ");
        }
        for (String wrongGuessedWord : wrongGuessedWords) {
            wrongChars.append(wrongGuessedWord).append(", ");
        }
        promptText += wrongChars + "\n" +
                "----------------------------------\n";
        if (isWrong) {
            promptText += guessedCharWord + "\n" +
                    "That was incorrect. Make another guess.\n";
        }
        else {
            promptText += guessedCharWord + "\n" +
                    "That was correct. Make another guess.\n";
        }
        return promptText;
    }

}
