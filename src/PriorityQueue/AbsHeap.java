package PriorityQueue;

import java.io.*;
import java.util.*;

public class AbsHeap {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> abs = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) > Math.abs(o2))
                return 1;
            else if (Math.abs(o1) == Math.abs(o2))
                return o1.compareTo(o2);
            else
                return -1;
        });
        int n = Integer.parseInt(br.readLine()), temp;

        for (int i = 0; i < n ;i++){
            temp =Integer.parseInt(br.readLine());

            if(temp == 0)
                bw.write(abs.isEmpty()? "0\n" : abs.poll() +"\n");
            else
                abs.add(temp);
        }
        bw.flush();
        bw.close();
    }


}


