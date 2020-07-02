package by.training.homework5.service;

import by.training.homework5.exception.UserException;

public interface DeleteText {
    String deleteWordsByLengthWithConsonant(String text, int length) throws UserException;

    String deletePunctuationInText(String text) throws UserException;
}
