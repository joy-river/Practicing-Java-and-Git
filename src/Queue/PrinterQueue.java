package Queue;

import java.io.*;
import java.util.*;

public class PrinterQueue {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Queue<node> que = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int num, count;
        String [] input, imp;

        for (int i = 0 ; i < n ; i ++){
            count = 0;
            input = br.readLine().split(" ");
            num = Integer.parseInt(input[0]);
            imp = br.readLine().split(" ");
            for (int j = 0 ; j< num ; j ++) {
                stack.add(Integer.parseInt(imp[j]));
                que.add(new node(stack.peek(), j));
            }

            Collections.sort(stack);

            while(stack.size() != 0){
                if(que.element().prio == stack.peek()){
                    count++;
                    if(que.element().order == Integer.parseInt(input[1])){
                        bw.write(count + "\n");
                        break;
                    }
                    else que.poll();
                    stack.pop();
                }
                else
                    que.add(que.poll());
            }

            stack.clear();
            que.clear();

        }

        bw.flush();
        bw.close();
    }
    static class node {
        int order;
        int prio;
        public node(int prio, int order) {
            this.prio = prio;
            this.order = order;
        }



    }

}
