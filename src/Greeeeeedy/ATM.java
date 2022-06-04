package Greeeeeedy;

import java.io.*;
import java.util.*;


public class ATM {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        ArrayList<Integer> time = new ArrayList<>();
        for (int i = 0 ; i < n ; i++)
            time.add(Integer.parseInt(st.nextToken()));

        Collections.sort(time);

        for (int i = 0 ; i < n ; i ++)
            sum += (long) time.get(i) * (n - i);



        bw.write(Long.toString(sum));
        bw.flush();
        bw.close();
    }

}

