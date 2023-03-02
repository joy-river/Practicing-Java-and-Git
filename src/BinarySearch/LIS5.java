package BinarySearch;

import java.io.*;
import java.util.*;

public class LIS5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        List<Lis> bdp = new ArrayList<>();
        Stack <Integer> result = new Stack<>();
        Lis temp;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        bdp.add(new Lis(-1, null));
        bdp.add(new Lis(arr[0], null));
        for (int i = 1; i < n ; i ++){
            dp[i] = dpsearch(arr[i], bdp, 1 , bdp.size() - 1);
        }
        bw.write(bdp.size() - 1 + "\n");
        temp = bdp.get(bdp.size() - 1);
        for (int i = 1 ; i < bdp.size() ; i++){
            result.add(temp.num);
            temp = temp.parent;
        }
        while(!result.isEmpty())
            bw.write(result.pop() + " ");

        bw.flush();
        bw.close();
    }
    static int dpsearch(int a, List<Lis> bdp, int start, int end){
        int mid = (start + end) / 2;
        if(start > end){
            if(start == bdp.size())
                bdp.add(new Lis(a, bdp.get(bdp.size() - 1)));
            else
            if(bdp.get(start).num > a)
                bdp.set(start, new Lis(a, bdp.get(start - 1)));
            return start;
        }

        if(bdp.get(mid).num > a)
            return dpsearch(a, bdp , start, mid - 1);
        else if(bdp.get(mid).num < a)
            return dpsearch(a, bdp, mid + 1, end);
        else
            return mid;
    }
    static class Lis {
        int num;
        Lis parent;

        public Lis(int num, Lis parent) {
            this.num = num;
            this.parent = parent;
        }
    }
}



