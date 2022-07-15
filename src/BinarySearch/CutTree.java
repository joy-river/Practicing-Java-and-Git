package BinarySearch;

import java.io.*;
import java.util.*;

public class CutTree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Long> wire = new ArrayList<>();
    static long m;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i ++)
            wire.add(Long.parseLong(st.nextToken()));
        Collections.sort(wire);
        cuttree(0 , wire.get(n - 1));
        bw.flush();
        bw.close();
    }

    static void cuttree(long start, long end) throws IOException {
        long mid = (start + end ) / 2;
        long count = 0;
        if(mid == start) {
            for (Long a : wire) count += a > end ? a - end : 0 ;
            bw.write(count >= m ? Long.toString(end) : Long.toString(start));
        }
        else{
            for (Long a : wire) count += a > mid ? a - mid : 0;
            if(count >= m)
                cuttree(mid, end);
            else
                cuttree(start , mid);
        }
    }

}
