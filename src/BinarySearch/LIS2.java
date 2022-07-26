package BinarySearch;

import java.io.*;
import java.util.*;

public class LIS2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        List<Integer> bdp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        bdp.add(-1);
        bdp.add(arr[0]);
        for (int i = 1; i < n ; i ++){
            dp[i] = dpsearch(arr[i], bdp, 1 , bdp.size() - 1);
        }
        bw.write(Integer.toString(bdp.size() - 1));
        bw.flush();
        bw.close();
    }
    static int dpsearch(int a, List bdp, int start, int end){
        int mid = (start + end) / 2;
        if(start > end){
            if(start == bdp.size())
                bdp.add(a);
            else
            if((int)bdp.get(start) > a)
                bdp.set(start, a);
            return start;
        }

        if((int)bdp.get(mid) > a)
            return dpsearch(a, bdp , start, mid - 1);
        else if( (int)bdp.get(mid) < a)
            return dpsearch(a, bdp, mid + 1, end);
        else
            return mid;



    }
}


