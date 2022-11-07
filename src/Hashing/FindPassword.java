package Hashing;

import java.io.*;
import java.util.*;

public class FindPassword {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> table = new HashMap<>();

        for (int i = 0 ; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            table.put(st.nextToken(), st.nextToken());
        }

        for (int j = 0 ; j < m ; j ++)
            bw.write(table.get(br.readLine()) +"\n");

        bw.flush();
        bw.close();
    }


}





