package DFSandBFS;

import java.io.*;
import java.util.*;

public class GoParty {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int inf = 50000000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int result = 0;
        int[][] link = new int[n + 1][n + 1];

        for (int i = 1 ; i <= n ; i++)
            for (int j = 1; j <=n; j ++) {
                if(i == j)
                    link[i][j] = 0;
                else
                    link[i][j] = inf;
            }

        for (int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            link[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= n; j++)
                for (int r = 1; r <= n; r++)
                    link[j][r] = Math.min(link[j][r], link[j][i] + link[i][r]);

        for (int i = 1; i <= n ; i++)
            result = Math.max(result, link[i][x] + link[x][i]);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }

}






