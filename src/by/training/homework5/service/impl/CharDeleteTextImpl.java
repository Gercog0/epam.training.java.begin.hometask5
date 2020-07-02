package by.training.homework5.service.impl;

import by.training.homework5.exception.UserException;
import by.training.homework5.service.DeleteText;

public class CharDeleteTextImpl implements DeleteText {
    private final static String VOWELS = "aeiouAEIOU";
    private final static String PUNCTUATION = "?!.:;<>,[]{}()@#$%^&*\'\"№~";
    private final static String SPACE = " ";
    private final static String DOUBLE_SPACE = "  ";

    @Override
    public String deleteWordsByLengthWithConsonant(String text, int length)
            throws UserException {
        if (text == null || length < 1) {
            throw new UserException("Incorrect data...");
        }
        String[] elementsText = text.split("\\b");
        StringBuilder newText = new StringBuilder();

        for (int i = 0; i < elementsText.length; i++) {
            char[] element = elementsText[i].toCharArray();
            if (element.length != length) {
                newText.append(elementsText[i]);
            } else {
                if (VOWELS.contains(String.valueOf(element[0]))) {
                    newText.append(elementsText[i]);
                }
            }
        }
        return newText.toString().trim();
    }

    @Override
    public String deletePunctuationInText(String text) throws UserException {
        if (text == null) {
            throw new UserException("Incorrect data...");
        }
        // Removing duplicate spaces for correct operation
        while (text.contains(DOUBLE_SPACE)) {
            text = text.replaceAll(DOUBLE_SPACE, SPACE);
        }

        String[] elementsText = text.split("\\b");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < elementsText.length; i++) {
            char[] element = elementsText[i].toCharArray();
            for (int j = 0; j < element.length; j++) {
                if (!PUNCTUATION.contains(String.valueOf(element[j]))) {
                    builder.append(element[j]);
                }
            }
        }

        for (int i = 0; i < builder.length() - 1; i++) {
            if (builder.charAt(i) == builder.charAt(i + 1)) {
                builder.insert(i + 1, SPACE);
            }
        }

        return builder.toString().trim();
    }
}
