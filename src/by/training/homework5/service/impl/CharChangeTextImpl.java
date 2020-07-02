package by.training.homework5.service.impl;

import by.training.homework5.exception.UserException;
import by.training.homework5.parser.StringParser;
import by.training.homework5.service.ChangeText;

public class CharChangeTextImpl implements ChangeText {
    private final static String SPACE = " ";

    @Override
    public String changeLetterByIndex(String text, int index, char newLetter)
            throws UserException {
        if (text == null || index < 1) {
            throw new UserException("Incorrect data...");
        }
        StringParser parser = new StringParser();
        String[] words = text.split(SPACE);
        StringBuilder newText = new StringBuilder();

        for (int j = 0; j < words.length; j++) {
            if (words[j].length() >= index) {
                char[] wordLetters = words[j].toCharArray();
                for (int i = 0; i < wordLetters.length; i++) {
                    if (i == index - 1) {
                        wordLetters[i] = newLetter;
                    }
                }
                words[j] = parser.parseCharArrayToString(wordLetters);
            }
            newText.append(words[j]).append(SPACE);
        }
        return newText.toString().trim();
    }

    @Override
    public String changeLettersAfterP(String text) throws UserException {
        if (text == null) {
            throw new UserException("Incorrect data...");
        }
        StringParser parser = new StringParser();
        String[] words = text.split(SPACE);
        StringBuilder newText = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            char[] wordLetters = words[i].toCharArray();
            for (int j = 0; j < wordLetters.length - 1; j++) {
                if ((wordLetters[j] == 'p' || wordLetters[j] == 'P') &&
                        (wordLetters[j + 1] == 'A' || wordLetters[j + 1] == 'a')) {
                    wordLetters[j + 1] = 'O';
                }
                words[i] = parser.parseCharArrayToString(wordLetters);
            }
            newText.append(words[i]).append(SPACE);
        }
        return newText.toString().trim();
    }

    @Override
    public String changeWordByLength(String text, int length, String newSubstring)
            throws UserException {
        if (text == null || newSubstring == null || length < 1) {
            throw new UserException("Incorrect data...");
        }
        String[] elementsText = text.split("\\b");
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < elementsText.length; i++) {
            if (elementsText[i].length() == length) {
                elementsText[i] = newSubstring;
            }
            builder.append(elementsText[i]);
        }
        return builder.toString().trim();
    }
}
