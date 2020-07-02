package by.training.homework5.parser;

public class StringParser {
    public String parseCharArrayToString(char[] charArray) {
        String string = "";
        for (int i = 0; i < charArray.length; i++) {
            string = string.concat(Character.toString(charArray[i]));
        }
        return string;
    }
}
