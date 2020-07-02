package reader;

import by.training.homework5.exception.UserException;
import by.training.homework5.reader.DataReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataReaderTest {
    DataReader reader;

    @BeforeClass
    public void setUp() {
        reader = new DataReader();
    }

    @Test
    public void dataReaderValid() {
        try {
            String expected = "Every day in elementary school in America begins at 9.20 a.m. \n" +
                    "Children have classes till 3.15 p.m. \n" +
                    "At 12 oclock children have lunch. \n" +
                    "Many boys and girls bring their lunch from home. \n" +
                    "But some of them go for lunch to a school cafeteria.";
            String actual = reader.dataReader("data.txt");
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Incorrect data...");
        }
    }

    @Test
    public void dataReaderInvalid() {
        try {
            String expected = "Hello";
            String actual = reader.dataReader("data.txt");
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Incorrect data...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void dataReaderUserException() throws UserException {
        reader.dataReader(null);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void dataReaderRuntimeException() throws RuntimeException, UserException {
        reader.dataReader("string.txt");
    }

    @AfterClass
    public void tierDown() {
        reader = null;
    }
}
