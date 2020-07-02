package by.training.homework5.service.impl;

import by.training.homework5.exception.UserException;


public class MAINTEST {

    public static void main(String[] args) throws UserException {

        RegexDeleteTextImpl deleteText = new RegexDeleteTextImpl();

        System.out.println(deleteText.deletePunctuationInText("H;e.llo! world!"));
    }
}
