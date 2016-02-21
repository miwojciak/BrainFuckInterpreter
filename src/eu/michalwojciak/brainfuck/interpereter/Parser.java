package eu.michalwojciak.brainfuck.interpereter;

/**
 * Created by misiek on 2016-02-21.
 */
public class Parser {
    public static String removeComments(String code) {
        StringBuffer parsed = new StringBuffer();
        for (char c :code.toCharArray())       {
            if (Commands.isCommand(c))
            parsed.append(c);
        }
        return parsed.toString();
    }
}
