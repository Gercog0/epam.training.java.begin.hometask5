package parser;

import by.training.homework5.parser.StringParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringParserTest {
    StringParser parser;

    @BeforeClass
    public void setUp() {
        parser = new StringParser();
    }

    @Test
    public void parseCharArrayToStringValid() {
        String expected = "HELLO";
        String actual = parser.parseCharArrayToString(new char[]{'H', 'E', 'L', 'L', 'O'});
        assertEquals(expected, actual);
    }

    @Test
    public void parseCharArrayToStringInvalid() {
        String expected = "HELLO";
        String actual = parser.parseCharArrayToString(new char[]{'H', 'O', 'L', 'L', 'A'});
        ;
        assertNotEquals(expected, actual);
    }

    @AfterClass
    public void tierDown() {
        parser = null;
    }
}
