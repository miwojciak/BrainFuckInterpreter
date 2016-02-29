package eu.mwo.brainfuck.interpereter;

class Commands {
    public static String commandsSymbols = "><+-[].,";

    public static boolean isCommand(char command) {
        return commandsSymbols.chars().anyMatch( c -> c == command);
    }

}
