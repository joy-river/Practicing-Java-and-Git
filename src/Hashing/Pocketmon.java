package Hashing;

import java.io.*;
import java.util.*;

public class Pocketmon {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer,String> c = new HashMap<>();
        HashMap<String,Integer> d = new HashMap<>();
        String temp;
        for (int i = 1 ; i <= n;  i++){
            temp = br.readLine();
            c.put(i, temp);
            d.put(temp, i);
        }

        for (int i = 0 ; i < m ; i++){
            temp = br.readLine();
            if(temp.charAt(0) > 64)
                bw.write(d.get(temp) + "\n");
            else
                bw.write(c.get(Integer.parseInt(temp)) + "\n");
        }

        bw.flush();
        bw.close();
    }
}





