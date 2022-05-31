package PrefixSum;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class HCI {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        String[] arr = br.readLine().split("");
        int n = Integer.parseInt(br.readLine());
        String alpha;
        ArrayList<Integer>[] sum = new ArrayList[26];
        int a,b;
        int index;

        for (int i = 0 ; i < 26; i ++)
            (sum[i] = new ArrayList<>()).add(0);
        sum[arr[0].charAt(0) - 97].set(0,1);

        for (int i = 0; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            alpha = st.nextToken();
            index = alpha.charAt(0) - 97;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(sum[index].size() <= b)
                for (int j = sum[index].size() ; j <= b  ; j++)
                    sum[index].add(sum[index].get(sum[index].size() -1 ) + (arr[j].equals(alpha) ? 1 : 0));
            bw.write(sum[index].get(b) - (a == 0 ? 0 : sum[index].get(a - 1))  + "\n");

        }
        bw.flush();
        bw.close();
    }

}

