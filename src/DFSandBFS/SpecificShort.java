package DFSandBFS;

import java.io.*;
import java.util.*;

public class SpecificShort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int inf = 50000000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b, c, result = inf;
        int [] cal = new int [3];

        int[][] link = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++) {
                if(i == j)
                    link[i][j] = 0;
                else
                    link[i][j] = inf;
            }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            link[a][b] = c;
            link[b][a] = c;
        }

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                for (int s = 1; s <= n; s++)
                    link[j][s] = Math.min(link[j][s], link[j][i] + link[i][s]);
        st = new StringTokenizer(br.readLine());

        cal[0] = 1;
        cal[1] = Integer.parseInt(st.nextToken());
        cal[2] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3 ;i ++) {
            result = Math.min(result, link[1][cal[1]] + link[cal[1]][cal[2]] + link[cal[2]][cal[i]] + link[cal[i]][n]);
            result = Math.min(result, link[1][cal[2]] + link[cal[2]][cal[1]] + link[cal[1]][cal[i]] + link[cal[i]][n]);
            result = Math.min(result, link[1][cal[1]] + link[cal[1]][1] + link[1][cal[2]] + link[cal[2]][cal[i]] + link[cal[i]][n]);
        }



        bw.write(result >= inf ? "-1" : Integer.toString(result));
        bw.flush();
        bw.close();
    }

}




