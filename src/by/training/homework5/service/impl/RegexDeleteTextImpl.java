package by.training.homework5.service.impl;

import by.training.homework5.exception.UserException;
import by.training.homework5.service.DeleteText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDeleteTextImpl implements DeleteText {
    private final static String PUNCTUATION = "\\p{Punct}";
    private final static String EMPTY_STRING = "";
    private final static String WORD_TO_DELETE_BY_LENGTH =
            "\\b([^aeiouAEIOU])[\\p{Lower}\\p{Upper}]{%d}\\b";
    private final static String SPACE = " ";

    @Override
    public String deleteWordsByLengthWithConsonant(String text, int length) throws UserException {
        if (text == null || length < 0) {
            throw new UserException("Incorrect data");
        }
        Pattern pattern = Pattern.compile(String.format(WORD_TO_DELETE_BY_LENGTH, length - 1));
        Matcher matcher = pattern.matcher(text);

        text = matcher.replaceAll(EMPTY_STRING);
        return text;
    }

    @Override
    public String deletePunctuationInText(String text) throws UserException {
        if (text == null) {
            throw new UserException("Incorrect data...");
        }
        Pattern pattern = Pattern.compile(PUNCTUATION);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(EMPTY_STRING);
        return text;
    }
}
