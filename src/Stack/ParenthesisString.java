package Stack;

import java.io.*;
import java.util.*;


public class ParenthesisString {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        String[] arr;
        boolean sayno;

        for (int i = 0 ; i < n; i ++) {
            arr = br.readLine().split("");
            sayno = false;
            if (arr.length % 2 != 0)
                bw.write("NO\n");
            else{
                for (String s : arr){
                    if (s.equals("("))
                        stack.push(s);
                    else {
                        if (stack.isEmpty()) {
                            sayno = true;
                            break;
                        } else
                            stack.pop();
                    }
                }
                bw.write(!sayno? stack.isEmpty()? "YES\n"  : "NO\n" : "NO\n");
                stack.clear();
            }
        }
        bw.flush();
        bw.close();
    }

}


