package service;

import by.training.homework5.exception.UserException;
import by.training.homework5.service.impl.StringChangeTextImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringChangeTextImplTest {
    StringChangeTextImpl change;

    @BeforeClass
    public void setUp() {
        change = new StringChangeTextImpl();
    }

    @DataProvider(name = "dataToChangeByIndexValid")
    public Object[][] createDataToChangeLetterByIndexValid() {
        return new Object[][]{
                {"HELLO IVAN", 3, '!', "HE!LO IV!N"},
                {"IVAN", 3, '?', "IV?N"},
                {"WORLD IS WORLD", 1, '.', ".ORLD .S .ORLD"}};
    }

    @DataProvider(name = "dataToChangeByIndexInvalid")
    public Object[][] createDataToChangeLetterByIndexInvalid() {
        return new Object[][]{
                {"HELLO IVAN", 5, '!', "HEL!O IVAN!"},
                {"IVAN", 1, '?', "IV?N"},
                {"WORLD IS WORLD", 20, '.', ".ORLD .S .ORLD"}};
    }

    @DataProvider(name = "dataToChangeByIndexException")
    public Object[][] createDataToChangeLetterByIndexException() {
        return new Object[][]{
                {null, 5, '!', "HEL!O IVAN!"},
                {"IVAN", -1, '?', "IV?N"},
                {null, -20, '.', ".ORLD .S .ORLD"}};
    }

    @DataProvider(name = "dataToChangeLettersAfterPValid")
    public Object[][] createDataToChangeLettersAfterPValid() {
        return new Object[][]{
                {"PACHIMY PROSTO TAK, PRABLEMA. GOVOR", "POCHIMY PROSTO TAK, PRABLEMA. GOVOR"},
                {"PAPAPAP", "POPOPOP"},
                {"pAl PA PAAAAA", "pOl PO POAAAA"}};
    }

    @DataProvider(name = "dataToChangeLettersAfterPInvalid")
    public Object[][] createDataToChangeLettersAfterPInvalid() {
        return new Object[][]{
                {"PACHIMY PROSTO TAK, PRABLEMA. GOVOR", "PACHIMY PRASTO TAK, PROBLEMA. GOVORA"},
                {"PAPAPAP", "PAPOPAPA"},
                {"pAl PA PAAAAA", "poL PA POAAAA"}};
    }

    @DataProvider(name = "dataToChangeWordByLengthValid")
    public Object[][] createDataToChangeWordByLengthValid() {
        return new Object[][]{
                {"HELLO IVAN AND IGOR", 4, "!", "HELLO ! AND !"},
                {"my name is ivan. i am from belarus", 4, "java the best",
                        "my java the best is java the best. i am java the best belarus"},
                {"WORLD IS WORLD", 5, "PERFECT", "PERFECT IS PERFECT"}};
    }

    @DataProvider(name = "dataToChangeWordByLengthInvalid")
    public Object[][] createDataToChangeWordByLengthInvalid() {
        return new Object[][]{
                {"HELLO IVAN AND IGOR", 4, "STRING", "HELLO STRING AND STR"},
                {"my name is ivan. i am from belarus", 2, "java",
                        "java name java ivan. i am from belarus"},
                {"WORLD IS WORLD", 6, "PERFECT", "PERFECT IS PERFECT"}};
    }

    @DataProvider(name = "dataToChangeWordByLengthException")
    public Object[][] createDataToChangeWordByLengthException() {
        return new Object[][]{
                {null, 4, "STRING"},
                {"my name is ivan. i am from belarus", -2, "java"},
                {"WORLD IS WORLD", 6, null}};
    }

    @Test(dataProvider = "dataToChangeByIndexValid")
    public void changeLetterByIndexValid(String text, int index,
                                         char newLetter, String afterChange) {
        try {
            String expected = afterChange;
            String actual = change.changeLetterByIndex(text, index, newLetter);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "dataToChangeByIndexInvalid")
    public void changeLetterByIndexInvalid(String text, int index,
                                           char newLetter, String afterChange) {
        try {
            String expected = afterChange;
            String actual = change.changeLetterByIndex(text, index, newLetter);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class, dataProvider = "dataToChangeByIndexException")
    public void changeLetterByIndexException(String text, int index, char newLetter,
                                             String afterChange) throws UserException {
        String expected = afterChange;
        String actual = change.changeLetterByIndex(text, index, newLetter);
        assertNotEquals(expected, actual);
    }

    @Test(dataProvider = "dataToChangeLettersAfterPValid")
    public void changeLettersAfterPValid(String text, String correctText) {
        try {
            String expected = correctText;
            String actual = change.changeLettersAfterP(text);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "dataToChangeLettersAfterPInvalid")
    public void changeLettersAfterPInvalid(String text, String correctText) {
        try {
            String expected = correctText;
            String actual = change.changeLettersAfterP(text);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void changeLettersAfterPException() throws UserException {
        change.changeLettersAfterP(null);
    }

    @Test(dataProvider = "dataToChangeWordByLengthValid")
    public void changeWordByLengthValid(String text, int length,
                                        String newSubstring, String correctText) {
        try {
            String expected = correctText;
            String actual = change.changeWordByLength(text, length, newSubstring);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "dataToChangeWordByLengthInvalid")
    public void changeWordByLengthInvalid(String text, int length,
                                          String newSubstring, String correctText) {
        try {
            String expected = correctText;
            String actual = change.changeWordByLength(text, length, newSubstring);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class, dataProvider = "dataToChangeWordByLengthException")
    public void changeWordByLengthException(String text, int length,
                                            String newSubstring) throws UserException {
        change.changeWordByLength(text, length, newSubstring);
    }

    @AfterClass
    public void tierDown() {
        change = null;
    }
}
