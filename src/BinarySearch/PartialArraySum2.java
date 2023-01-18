package BinarySearch;

import java.io.*;
import java.util.*;

public class PartialArraySum2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Integer, Integer> Halfsum = new HashMap<>();
    static long result = 0;
    static int n , s;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int[] list = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++)
            list[i] = Integer.parseInt(st.nextToken());
        Get_PartSum(list, n / 2, 0, n - n / 2);
        Check(list, 0,  0, n / 2);

        bw.write(Long.toString(s == 0 ? result - 1 : result));
        bw.flush();
        bw.close();
    }

    static void Get_PartSum (int[] list, int start, int sum, int count){

        if(count == 0) {
            if (!Halfsum.containsKey(sum))
                Halfsum.put(sum, 1);
            else
                Halfsum.replace(sum, Halfsum.get(sum) + 1);
        }

        if(start == n)
            return;
        Get_PartSum(list, start + 1 , sum, count - 1);
        Get_PartSum(list, start + 1,  sum + list[start], count - 1);
    }

    static void Check (int[] list, int start, int sum, int count){
        if(count == 0 && Halfsum.containsKey(s - sum))
            result += Halfsum.get(s - sum);

        if(start == n / 2)
            return;
        Check(list, start + 1, sum, count - 1);
        Check(list, start + 1, sum + list[start], count - 1);

    }

}



