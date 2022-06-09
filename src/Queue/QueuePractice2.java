package Queue;

import java.io.*;
import java.util.*;

public class QueuePractice2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Queue<Integer> que = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int back = 0;
        String[] input;

        for (int i = 0 ; i < n ; i ++){
            input = br.readLine().split(" ");
            switch(input[0]){
                case "push" : que.add(Integer.parseInt(input[1])); back = Integer.parseInt(input[1]); break;
                case "pop" : bw.write((que.isEmpty() ? -1 : que.poll()) + "\n"); break;
                case "size" : bw.write(que.size() + "\n"); break;
                case "empty" : bw.write((que.isEmpty() ? 1 : 0) + "\n"); break;
                case "front" : bw.write((que.isEmpty() ? -1  : que.peek()) + "\n"); break;
                case "back" : bw.write((que.isEmpty() ? -1  : back) + "\n"); break;
            }

        }

        bw.flush();
        bw.close();
    }
}


