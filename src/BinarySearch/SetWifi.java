package BinarySearch;

import java.io.*;
import java.util.*;

public class SetWifi {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> wire = new ArrayList<>();
    static int n;
    static long output = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0 ; i < n ; i ++)
            wire.add(Integer.parseInt(br.readLine()));


        Collections.sort(wire);
        setwifi(1, wire.get(n - 1), m);
        bw.write(Long.toString(output));
        bw.flush();
        bw.close();
    }

    static void setwifi(int start , int end, int m) throws IOException{
        int mid = (start + end) / 2;
        int count = 1;
        int index = 0;
        if(start > end)
            return;
        else {
            for (int i =  1; i < n; i++) {
                if (wire.get(i) - wire.get(index) >= mid) {
                    index = i;
                    count++;
                }
            }
            if (count >= m) {
                output = mid;
                setwifi(mid + 1, end, m);
            } else
                setwifi(start, mid - 1, m);
        }
    }
}



