package Stack;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BalancedWorld {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        Pattern p = Pattern.compile("[)(\\[\\]]");
        Matcher m;
        String s;
        boolean sayno;

        s = br.readLine();
        while(!s.equals(".")) {
            m = p.matcher(s);
            sayno = false;
            while(m.find() && !sayno){
                switch(m.group()){
                    case "(" : stack.push(1); break;
                    case ")" :
                        if (stack.isEmpty())
                            sayno = true;
                        else
                        if(stack.pop() != 1 ) sayno = true;
                        break;
                    case "[" : stack.push(2); break;
                    case "]" :
                        if(stack.isEmpty())
                            sayno = true;
                        else
                        if(stack.pop() != 2) sayno = true;
                        break;
                }
            }
            bw.write(!sayno? stack.isEmpty()? "yes\n" : "no\n" : "no\n");
            s = br.readLine();
            stack.clear();
        }
        bw.flush();
        bw.close();
    }

}



