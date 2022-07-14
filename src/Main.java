import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> wire = new ArrayList<>();
    static int n;
    public static void main(String[] args) throws IOException {
       StringTokenizer st = new StringTokenizer(br.readLine());
       int k = Integer.parseInt(st.nextToken());
       n = Integer.parseInt(st.nextToken());
       for (int i = 0 ; i < k ; i ++)
           wire.add(Integer.parseInt(br.readLine()));
       Collections.sort(wire);
        cut(0 , wire.get(k - 1));
        bw.flush();
        bw.close();
    }

    static void cut(int start, int end) throws IOException {
        int mid = Math.toIntExact((long) (start + end) / 2);
        int count = 0;
        if(mid == start)
            bw.write(Integer.toString(start));
        else{
            for (Integer integer : wire) count += integer / mid;
            if(count > n)
                cut(mid + 1, end);
            else if (count < n)
                cut(start , mid - 1);
            else
                cut(mid, end);
        }
    }

}


