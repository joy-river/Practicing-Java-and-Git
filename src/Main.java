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
       output = wire.get(n - 1) - wire.get(0);
       setwifi(0, n- 1, m - 2);
        bw.write(Long.toString(output));
        bw.flush();
        bw.close();
    }

    static void setwifi(int start, int end, int m) throws IOException{
        if(m == 0)
            return;
        else {
            long mid = (wire.get(start) + wire.get(end)) / 2;
            if(wire.contains(mid)){

            }
            else{

            }
        }


    }

}


