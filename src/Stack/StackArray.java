package Stack;

import java.io.*;
import java.util.*;


public class StackArray {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int [] num = new int[n + 1];
        int j = 1, last = 0;
        boolean no = false;

        for (int i = 1; i <= n ; i ++){
            num[i] = Integer.parseInt(br.readLine());
            if(num[i] >= j) {
                while(j <= num[i]){
                    stack.push(j++);
                    sb.append("+\n");
                }
                last = stack.pop() - 1;
                sb.append("-\n");
            }
            else if(num[i] < j){
                if(num[i] <= last){
                    if(stack.isEmpty()) {
                        no = true;
                        break;
                    }
                    sb.append("-\n");
                    while(num[i] != stack.pop())
                        sb.append("-\n");
                    last = num[i] - 1;
                }
                else {
                    no = true;
                    break;
                }
            }
        }
        bw.write(no? "NO" : sb.toString());
        bw.flush();
        bw.close();
    }

}



