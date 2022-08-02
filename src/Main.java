
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine()), temp;
        for (int i = 0; i < n ;i++){
            temp =Integer.parseInt(br.readLine());
            if(i % 2 == 0) {
                left.add(temp);
            }
            else
                right.add(temp);
        }
        bw.flush();
        bw.close();
    }


}


