import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String temp;
        StringTokenizer st;
        for (int i = 0 ; i < n ; i ++) {
            PriorityQueue<Integer> dual = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            temp = st.nextToken();
            if(temp.equals("I")){dual.add(Integer.parseInt(st.nextToken()));}
            if(temp.equals("D")){dual.remove(Integer.parseInt(st.nextToken()));}
        }



        bw.flush();
        bw.close();

    }

}
