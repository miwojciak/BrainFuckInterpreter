package eu.michalwojciak.brainfuck.interpereter;

/**
 * Created by misiek on 2016-02-21.
 */
public class App {
    public static void main(String[] args) {
        System.out.print("Start");

        String code =
                "+++++ +++               Set Cell #0 to 8\n" +
                "[\n" +
                "    >++++               Add 4 to Cell #1; this will always set Cell #1 to 4\n" +
                "    [                   as the cell will be cleared by the loop\n" +
                "        >++             Add 2 to Cell #2\n" +
                "        >+++            Add 3 to Cell #3\n" +
                "        >+++            Add 3 to Cell #4\n" +
                "        >+              Add 1 to Cell #5\n" +
                "        <<<<-           Decrement the loop counter in Cell #1\n" +
                "    ]                   Loop till Cell #1 is zero; number of iterations is 4\n" +
                "    >+                  Add 1 to Cell #2\n" +
                "    >+                  Add 1 to Cell #3\n" +
                "    >-                  Subtract 1 from Cell #4\n" +
                "    >>+                 Add 1 to Cell #6\n" +
                "    [<]                 Move back to the first zero cell you find; this will\n" +
                "                        be Cell #1 which was cleared by the previous loop\n" +
                "    <-                  Decrement the loop Counter in Cell #0\n" +
                "]                       Loop till Cell #0 is zero; number of iterations is 8\n" +
                "\n" +
                "The result of this is:\n" +
                "Cell No :   0   1   2   3   4   5   6\n" +
                "Contents:   0   0  72 104  88  32   8\n" +
                "Pointer :   ^\n" +
                "\n" +
                ">>.                     Cell #2 has value 72 which is 'H'\n" +
                ">---.                   Subtract 3 from Cell #3 to get 101 which is 'e'\n" +
                "+++++++..+++.           Likewise for 'llo' from Cell #3\n" +
                ">>.                     Cell #5 is 32 for the space\n" +
                "<-.                     Subtract 1 from Cell #4 for 87 to give a 'W'\n" +
                "<.                      Cell #3 was set to 'o' from the end of 'Hello'\n" +
                "+++.------.--------.    Cell #3 for 'rl' and 'd'\n" +
                ">>+.                    Add 1 to Cell #5 gives us an exclamation point\n" +
                ">++.                    And finally a newline from Cell #6";


//        code = "++++++++[->-[->-[->-[-]<]<]<]\n" +
//                ">++++++++[<++++++++++>-]<[>+>+<<-]>-.>-----.>";

        Interpreter interpreter;
        interpreter = new Interpreter(code);
        interpreter.run();
    }
}
