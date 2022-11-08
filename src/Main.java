import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        Stack<String> oper = new Stack<>();
        Stack<String> result = new Stack<>();

        boolean b =false;
        for (String s : input) {
            if (s.charAt(0) - 65 >= 0)
                result.add(s);
            else if (s.equals("("))
                b = true;
            else if (s.equals(")")) {
                sb.append(print(alpha, bracket));
                b = false;
            }
            else if (s.equals("+") || s.equals("-")) {
                if (!bracket.isEmpty())
                    if (bracket.peek().equals("*") || bracket.peek().equals("/"))
                        if(!b)
                            sb.append(print(alpha, bracket));
                bracket.push(s);
            }
            else
                bracket.push(s);
        }
        sb.append(print(alpha,bracket));


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}





