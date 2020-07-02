package by.training.homework5.service;

import by.training.homework5.exception.UserException;

public interface ChangeText {
    String changeLetterByIndex(String text, int index, char newLetter) throws UserException;

    String changeLettersAfterP(String text) throws UserException;

    String changeWordByLength(String text, int length, String newSubstring) throws UserException;
}
