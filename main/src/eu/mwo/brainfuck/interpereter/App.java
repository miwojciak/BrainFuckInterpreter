package eu.mwo.brainfuck.interpereter;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) return;

        new Interpreter(args[0], System.out).run();
    }
}
