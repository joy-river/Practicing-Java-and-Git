package Queue;

import java.io.*;
import java.util.*;

public class DequePractice {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Deque<Integer> deq = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        String[] input;
        for (int i = 0 ; i < n ; i ++){
            input = br.readLine().split(" ");
            switch(input[0]){
                case "push_front": deq.addFirst(Integer.parseInt(input[1])); break;
                case "push_back": deq.addLast(Integer.parseInt(input[1])); break;
                case "pop_front": bw.write((deq.isEmpty()? -1 : deq.pollFirst()) +"\n"); break;
                case "pop_back": bw.write((deq.isEmpty()? -1 : deq.pollLast())+"\n" ); break;
                case "size" : bw.write(deq.size() +"\n"); break;
                case "empty": bw.write((deq.isEmpty()? 1 : 0) +"\n"); break;
                case "front": bw.write((deq.isEmpty()? -1 : deq.peekFirst()) +"\n"); break;
                case "back": bw.write((deq.isEmpty()? -1 : deq.peekLast()) +"\n"); break;
            }

        }
        bw.flush();
        bw.close();
    }

}
