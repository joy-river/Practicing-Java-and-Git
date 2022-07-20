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
        setwifi(n - 1, m);
        bw.write(Long.toString(output));
        bw.flush();
        bw.close();
    }

    static void setwifi(int end, int m) throws IOException{
        int mid = end / 2;
        int count = 1;
        long temp = wire.get(mid) - wire.get(0);
        for (int i = mid; i <= end; i++)

        }
    }
}


