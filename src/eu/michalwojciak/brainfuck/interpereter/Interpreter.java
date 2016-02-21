package eu.michalwojciak.brainfuck.interpereter;

/**
 * Created by misiek on 2016-02-21.
 */
public class Interpreter {

    char[] code;
    byte[] memory = new byte[30000];
    int mem_ptr = 0;
    int i_ptr = 0;

    public Interpreter(String code) {
        String s = Parser.removeComments(code);
        System.out.format("Running code: %s \n", s);
        this.code = s.toCharArray();
    }

    public void run() {
        do {
            char commmand = code[i_ptr];
            switch (commmand){
                case '>':
                    mem_ptr++;
                    break;
                case '<':
                    mem_ptr--;
                    break;
                case '+':
                    memory[mem_ptr]++;
                    break;
                case '-':
                    memory[mem_ptr]--;
                    break;
                case '.':
                    System.out.print(((char) memory[mem_ptr]));
                    break;
                case ',':
                    memory[mem_ptr]='a';
                    break;
                case '[':
                    if (memory[mem_ptr] == 0) {
                        //go to ] + 1
                        int loop_num = 0;
                        do {
                            i_ptr++;
                            if (code[i_ptr] == ']' && loop_num == 0) break;
                            else if (code[i_ptr] == '[') loop_num++;
                            else if (code[i_ptr] == ']') loop_num--;
                        } while (true);
                    }
                    break;
                case ']':
                    if (memory[mem_ptr] != 0) {
                        //go to [ + 1
                        int loop_num = 0;
                        do {
                            i_ptr--;
                            if (code[i_ptr] == '[' && loop_num == 0) break;
                            else if (code[i_ptr] == ']') loop_num++;
                            else if (code[i_ptr] == '[') loop_num--;
                        } while (true);
                    }
                    break;
                default: throw new RuntimeException("Wrong BrainFuck mnemonic");

            }
            i_ptr++;
        }
        while( i_ptr != code.length);
    }


}
