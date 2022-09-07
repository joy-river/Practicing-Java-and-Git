package Hashing;

import java.io.*;
import java.util.*;

public class NeverSeenorHeard {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> jab = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        String temp;
        for (int i = 0 ; i < n ; i ++)
            jab.add(br.readLine());
        for (int i = 0 ; i < m ; i ++) {
            temp = br.readLine();
            if(jab.contains(temp))
                result.add(temp);
        }
        bw.write(result.size() + "\n");
        Collections.sort(result);
        for (int i = 0 ; i < result.size(); i++)
            bw.write(result.get(i) + "\n");
        bw.flush();
        bw.close();
    }
}






