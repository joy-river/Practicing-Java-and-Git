package Stack;

import java.io.*;
import java.util.*;

public class RightBigNumber {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Stack<node> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");
        ArrayList<Integer> valid = new ArrayList<>();
        int [] nge = new int[n + 1];
        int temp = 0;

        for (int i = 0; i < n; i ++){
            temp = Integer.parseInt(num[i]);
            nge[i] = -1;
            if(stack.size() == 0 || stack.peek().num >= temp)
                stack.push(new node(temp,i));
            else if (stack.peek().num < temp){
                while(stack.size() != 0 && stack.peek().num < temp){
                    nge[stack.pop().order] = temp;
                }
                stack.push(new node(temp, i));
            }
        }

        for (int i = 0; i < n ; i++)
            bw.write(nge[i] + " ");
        bw.flush();
        bw.close();
    }

    static class node {
        int num;
        int order;
        public node(int num, int order) {
            this.num = num;
            this.order = order;
        }

    }

}


