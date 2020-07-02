package by.training.homework5.service.impl;

import by.training.homework5.exception.UserException;
import by.training.homework5.service.ChangeText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChangeTextImpl implements ChangeText {
    private final static String INCORRECT_LETTERS = "pa|Pa";
    private final static String CORRECT_LETTERS = "po";
    private final static String LETTER_IN_WORLD = "(?<=\\b\\S{%d})\\S";
    private final static String WORLD_BY_LENGTH = "\\b[\\p{Lower}\\p{Upper}]{%d}\\b";

    @Override
    public String changeLetterByIndex(String text, int index, char newLetter) throws UserException {
        if (text == null || index < 1) {
            throw new UserException("Incorrect data...");
        }
        Pattern pattern = Pattern.compile(String.format(LETTER_IN_WORLD, index - 1));
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(String.valueOf(newLetter));
        return text;
    }

    @Override
    public String changeLettersAfterP(String text) throws UserException {
        if (text == null) {
            throw new UserException("Incorrect data...");
        }
        Pattern pattern = Pattern.compile(INCORRECT_LETTERS);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(CORRECT_LETTERS);
    }

    @Override
    public String changeWordByLength(String text, int length, String newSubstring)
            throws UserException {
        if (text == null || newSubstring == null || length < 1) {
            throw new UserException("Incorrect data...");
        }
        Pattern pattern = Pattern.compile(String.format(WORLD_BY_LENGTH, length));
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(newSubstring);
        return text;
    }
}
