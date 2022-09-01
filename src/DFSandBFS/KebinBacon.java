package DFSandBFS;

import java.io.*;
import java.util.*;

public class KebinBacon {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b;
        int result = 150;
        int[][] link = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                link[i][j] = 150;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            link[a][b] = 1;
            link[b][a] = 1;
        }
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                for (int s = 1; s <= n; s++)
                    link[j][s] = Math.min(link[j][s], link[j][i] + link[i][s]);

        b = 0;
        for (int i = 1; i <= n; i++) {
            a = 0;
            for (int j = 1; j <= n; j++)
                a += link[i][j];
            if (result > (a -= link[i][i])) {
                result = a;
                b = i;
            }
        }

        bw.write(Integer.toString(b));
        bw.flush();
        bw.close();
    }
}





