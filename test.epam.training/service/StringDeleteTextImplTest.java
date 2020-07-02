package service;

import by.training.homework5.exception.UserException;
import by.training.homework5.service.impl.StringDeleteTextImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringDeleteTextImplTest {
    StringDeleteTextImpl delete;

    @BeforeClass
    public void setUp() {
        delete = new StringDeleteTextImpl();
    }

    @DataProvider(name = "dataToDeleteWordsByLengthValid")
    public Object[][] createDataToDeleteWordsByLengthValid() {
        return new Object[][]{
                {"hello world. My name is Ivano", 5, ". My name is Ivano"},
                {"esli tak mozhno to mozhno", 6, "esli tak  to"}};
    }

    @DataProvider(name = "dataToDeleteWordsByLengthInvalid")
    public Object[][] createDataToDeleteWordsByLengthInvalid() {
        return new Object[][]{
                {"hello world. My name is Ivano", 5, ". My name is "},
                {"esli tak mozhno to mozhno", 6, "esli tak to"}};
    }

    @DataProvider(name = "dataToDeletePunctuationInTextValid")
    public Object[][] createDataToDeletePunctuationInTextValid() {
        return new Object[][]{
                {"hello world. My name is Ivano", "hel lo world My name is Ivano"},
                {"esli! tak! mozhno? to moz?hno", "esli tak mozhno to mozhno"}};
    }

    @DataProvider(name = "dataToDeletePunctuationInTextInvalid")
    public Object[][] createDataToDeletePunctuationInTextInvalid() {
        return new Object[][]{
                {"hello world. My name is Ivano", "hello world My name is Ivano"},
                {"esli! tak! mozhno? to moz?hno", "esli tak mozhno to moz?hno"}};
    }

    @Test(dataProvider = "dataToDeleteWordsByLengthValid")
    public void deleteWordsByLengthWithConsonantValid(String text, int length, String correctText) {
        try {
            String expected = correctText;
            String actual = delete.deleteWordsByLengthWithConsonant(text, length);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "dataToDeleteWordsByLengthInvalid")
    public void deleteWordsByLengthWithConsonantInvalid(String text, int length, String correctText) {
        try {
            String expected = correctText;
            String actual = delete.deleteWordsByLengthWithConsonant(text, length);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void deleteWordsByLengthWithConsonantException() throws UserException {
        delete.deleteWordsByLengthWithConsonant(null, -1);
    }

    @Test(dataProvider = "dataToDeletePunctuationInTextValid")
    public void deletePunctuationInTextValid(String text, String correctText) {
        try {
            String expected = correctText;
            String actual = delete.deletePunctuationInText(text);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "dataToDeletePunctuationInTextInvalid")
    public void deletePunctuationInTextInvalid(String text, String correctText) {
        try {
            String expected = correctText;
            String actual = delete.deletePunctuationInText(text);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void deletePunctuationInTextException() throws UserException {
        delete.deletePunctuationInText(null);
    }

    @AfterClass
    public void tierDown() {
        delete = null;
    }
}
