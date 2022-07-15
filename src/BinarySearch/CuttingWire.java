package BinarySearch;

import java.io.*;
import java.util.*;

public class CuttingWire {
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
        cut(1 , wire.get(k - 1));
        bw.flush();
        bw.close();
    }

    static void cut(long start, long end) throws IOException {
        long mid = (start + end ) / 2;
        int count = 0;
        if(mid == start) {
            for (Integer integer : wire) count += integer / end;
            bw.write(count >= n ? Long.toString(end) : Long.toString(start));
        }
        else{
            for (Integer integer : wire) count += integer / mid;
            if(count >= n)
                cut(mid, end);
            else
                cut(start , mid);
        }
    }

}