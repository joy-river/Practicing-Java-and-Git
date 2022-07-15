import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Long> wire = new ArrayList<>();
    static int m;
    static long output = 0;
    public static void main(String[] args) throws IOException {
       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       for (int i = 0 ; i < n ; i ++)
           wire.add(Long.parseLong(br.readLine()));
       Collections.sort(wire);
       for (int i = 0 ; i <= n- m; i ++){
            setwifi(i);
       }

        bw.flush();
        bw.close();
    }

    static void setwifi(int i) throws IOException{

    }

}


