package Queue;

import java.io.*;
import java.util.*;

public class Card2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Queue<Integer> que = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1 ; i <= n ; i ++)
            que.add(i);

        while(que.size() != 1){
            que.poll();
            que.add(que.poll());
        }

        bw.write(Integer.toString(que.poll()));
        bw.flush();
        bw.close();
    }

}


