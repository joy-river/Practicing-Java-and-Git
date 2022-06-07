package Stack;

import java.io.*;
import java.util.*;


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        String[][] com = new String[n][];

        for (int i = 0 ; i < n ;i ++) {
            com[i] = br.readLine().split(" ");
            switch(com[i][0]) {
                case "push": stack.push(Integer.parseInt(com[i][1])); break;
                case "pop" : bw.write((stack.isEmpty()? "-1" : stack.pop()) + "\n"); break;
                case "size" : bw.write(stack.size() + "\n"); break;
                case "empty" : bw.write((stack.isEmpty()? "1" : "0") + "\n"); break;
                case "top" : bw.write((stack.isEmpty()? "-1" : stack.lastElement()) + "\n"); break;
            }
        }


        bw.flush();
        bw.close();
    }

}


