import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> abs = new PriorityQueue<>(Collections.reverseOrder((o1,o2) -> Math.abs(o1) > Math.abs(o2) ?  o2 : o1));
        int n = Integer.parseInt(br.readLine()), temp;

        for (int i = 0; i < n ;i++){
            temp =Integer.parseInt(br.readLine());

            if(temp == 0)
                bw.write(abs.isEmpty()? "0\n" : abs.poll() +"\n");
            else
                abs.offer(temp);
        }
        bw.flush();
        bw.close();
    }


}


