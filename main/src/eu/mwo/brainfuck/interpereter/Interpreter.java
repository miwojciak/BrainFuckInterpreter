package eu.mwo.brainfuck.interpereter;


import java.io.PrintStream;

public class Interpreter {

    char[] code;
    byte[] memory = new byte[30000];
    int mem_ptr = 0;
    int i_ptr = 0;
    PrintStream out;

    public Interpreter(String code, PrintStream out) {
        String s = Parser.removeComments(code);
        this.code = s.toCharArray();
        if (out != null) {
            this.out = out;
        }
    }

    public void run() {
        for ( ; i_ptr != code.length ; i_ptr++ )  {
            switch (code[i_ptr]){
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
                    out.print(((char) memory[mem_ptr]));
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

        }
    }
}
