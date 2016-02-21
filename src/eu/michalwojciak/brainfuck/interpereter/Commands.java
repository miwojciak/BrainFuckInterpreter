package eu.michalwojciak.brainfuck.interpereter;

/**
 * Created by misiek on 2016-02-21.
 */
public class Commands {
    public static char commands [] = {'>', '<', '+', '-', '[', ']', '.', ','};

    public static boolean isCommand(char command) {
        for (char c : commands) {
            if (c == command) return true;
        }
        return false;
    }

}
