package PriorityQueue;


import java.io.*;
import java.util.*;

public class MiddleHeap {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine()), temp;
        for (int i = 0; i < n ;i++){
            temp = Integer.parseInt(br.readLine());
            if(right.size() == 0 || temp >= right.peek())
                right.add(temp);
            else if(temp < right.peek())
                left.add(temp);
            if(right.size() - left.size() > 1)
                left.add(right.poll());
            else if(left.size() - right.size() > 1)
                right.add(left.poll());
            if(i % 2 == 0)
                bw.write(right.size() > left.size() ? right.peek() + "\n": left.peek()+"\n");
            else
                bw.write(Math.min(left.peek(), right.peek()) + "\n");
        }
        bw.flush();
        bw.close();
    }


}



