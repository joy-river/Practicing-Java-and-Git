import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        Stack<oper> oper = new Stack<>();
        Stack<String> result = new Stack<>();
        int b = 0;

        for (String s : input) {
            if (s.charAt(0) - 65 >= 0)
                result.add(s);
            else{
                switch (s){
                    case "+" :
                    case "-" :
                        oper.add(new oper(s, b)); break;
                    case "*":
                    case "/":
                        oper.add(new oper(s, 1 +b)); break;
                    case "(": b++; break;
                    case ")": b--; break;
                }
                check(oper, result);
            }
        }
        while(!oper.isEmpty())
            result.add(oper.pop().op);


        while(!result.isEmpty())
          sb.append(result.pop());
        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
    }
    static void check (Stack<oper> oper, Stack<String> result) {
        oper temp;
        if(oper.size() == 1);
        else{
            temp = oper.pop();
            if(temp.prio >= oper.peek().prio)
                oper.add(temp);
            else {
                while (!oper.isEmpty()) {
                    if (temp.prio <= oper.peek().prio)
                        result.add(oper.pop().op);
                    else
                        break;
                }
                oper.add(temp);
            }
        }
    }

}
class oper {
    public oper(String op, int prio) {
        this.op = op;
        this.prio = prio;
    }

    String op;
    int prio;

}




