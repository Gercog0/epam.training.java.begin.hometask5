package by.training.homework5.service.impl;

import by.training.homework5.exception.UserException;
import by.training.homework5.service.ChangeText;

public class StringChangeTextImpl implements ChangeText {
    private final static String SPACE = " ";
    private final static String BLANK = "";

    @Override
    public String changeLetterByIndex(String text, int index, char newLetter) throws UserException {
        if (text == null || index < 1) {
            throw new UserException("Incorrect data...");
        }

        String[] words = text.split(SPACE);
        String newText = BLANK;
        for (String word : words) {
            if (word.length() > index) {
                StringBuilder builder = new StringBuilder(word);
                builder.setCharAt(index - 1, newLetter);
                newText = newText.concat(builder.toString()).concat(SPACE);
            }
        }
        return newText.trim();
    }

    @Override
    public String changeLettersAfterP(String text) throws UserException {
        if (text == null) {
            throw new UserException("Incorrect data...");
        }
        String[] words = text.split(SPACE);
        String newText = BLANK;
        for (String word : words) {
            StringBuilder builder = new StringBuilder(word);
            for (int i = 0; i < builder.length() - 1; i++) {
                if ((builder.charAt(i) == 'P' || builder.charAt(i) == 'p') &&
                        (builder.charAt(i + 1) == 'A' || builder.charAt(i + 1) == 'a')) {
                    builder.replace(i + 1, i + 2, "O");
                }
            }
            newText = newText.concat(builder.toString());
            newText = newText.concat(SPACE);
        }
        return newText.trim();
    }

    @Override
    public String changeWordByLength(String text, int length, String newSubstring)
            throws UserException {
        if (text == null || newSubstring == null || length < 1) {
            throw new UserException("Incorrect data...");
        }

        String[] words = text.split("\\b");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == length) {
                words[i] = newSubstring;
            }
            builder.append(words[i]);

        }
        return builder.toString().trim();
    }
}
