package eu.mwo.brainfuck.interpereter;

public class Parser {
    public static String removeComments(String code) {
        StringBuffer parsed = new StringBuffer();

        code.chars().filter( c -> Commands.isCommand((char) c) )
                .forEach( d-> parsed.append((char) d));

        return parsed.toString();
    }
}
