package Stack;

import java.io.*;
import java.util.*;


public class Zero {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] num = new int [n];
        int sum = 0;

        for (int i = 0 ; i < n; i ++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
            if (num[i] == 0)
                sum -= stack.pop();
            else
                stack.push(num[i]);
        }

        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
    }

}



