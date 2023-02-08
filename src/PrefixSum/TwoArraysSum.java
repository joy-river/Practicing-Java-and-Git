package PrefixSum;

import java.io.*;
import java.util.*;


public class TwoArraysSum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        long last = 0;
        long result = 0L;
        HashMap<Long, Long> Sum_Count = new HashMap<>();
        HashMap<Long, Long> b_Sum_Count = new HashMap<>();
        HashMap<Long, Long> temp = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        temp.put(0L, 1L);
        for (int i = 0 ; i < n ; i ++) {
            last += Long.parseLong(st.nextToken());
            for (Long key : temp.keySet())
                Sum_Count.put(last - key, Sum_Count.getOrDefault(last - key, 0L) + temp.get(key));
            temp.put(last, temp.getOrDefault(last, 0L) + 1);
        }

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        last = 0;
        temp.clear();
        temp.put(0L, 1L);
        for (int i = 0 ; i < n ; i ++) {
            last += Integer.parseInt(st.nextToken());
            for (Long key : temp.keySet())
                b_Sum_Count.put(last - key, b_Sum_Count.getOrDefault(last - key, 0L)+ temp.get(key));
            temp.put(last, temp.getOrDefault(last, 0L) + 1);
        }


        for (Long key : Sum_Count.keySet())
            if(b_Sum_Count.containsKey(t - key))
                result += (b_Sum_Count.get(t - key) * Sum_Count.get(key));



        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
    }



}
