package by.training.homework5.service.impl;

import by.training.homework5.exception.UserException;
import by.training.homework5.service.DeleteText;

public class StringDeleteTextImpl implements DeleteText {
    private final static String VOWELS = "aeiouAEIOU";
    private final static String PUNCTUATION = "\\p{Punct}";
    private final static String SPACE = " ";
    private final static String DOUBLE_SPACE = "  ";

    @Override
    public String deleteWordsByLengthWithConsonant(String text, int length)
            throws UserException {
        if (text == null || length < 1) {
            throw new UserException("Incorrect data...");
        }
        String[] words = text.split("\\b");
        StringBuilder builder = new StringBuilder();
        for (String element : words) {
            if (element.length() != length) {
                builder.append(element);
            } else {
                if (VOWELS.contains(String.valueOf(element.charAt(0)))) {
                    builder.append(element);
                }
            }
        }
        return builder.toString().trim();
    }

    @Override
    public String deletePunctuationInText(String text) throws UserException {
        if (text == null) {
            throw new UserException("Incorrect data...");
        }
        String newText = text.replaceAll(PUNCTUATION, "");

        // Removing duplicate spaces for correct operation
        while (newText.contains(DOUBLE_SPACE)) {
            newText = newText.replaceAll(DOUBLE_SPACE, SPACE);
        }
        StringBuilder builder = new StringBuilder(newText);

        for (int i = 0; i < builder.length() - 1; i++) {
            if (builder.charAt(i) == builder.charAt(i + 1)) {
                builder.insert(i + 1, SPACE);
            }
        }
        return builder.toString();
    }
}
