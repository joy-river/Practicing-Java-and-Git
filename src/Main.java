import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int temp;
        for (int i =  0 ;  i < n; i++){
            temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                bw.write(min.isEmpty() ? "0\n" : min.poll() + "\n");
            }
            else
                min.add(temp);

        }
        bw.flush();
        bw.close();
    }


}


