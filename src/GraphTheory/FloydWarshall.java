package GraphTheory;

import java.io.*;
import java.util.*;

public class FloydWarshall {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int a, b, c;
        int [][] link = new int[n + 1][n + 1];

        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            link[a][b] = link[a][b] != 0 ? Math.min(link[a][b], c) : c;
        }

        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= n; j++)
                for(int s = 1; s <= n; s++) {
                    if(link[j][i] != 0 && link[i][s] != 0)
                        link[j][s] = link[j][s] != 0 ? Math.min(link[j][s],link[j][i] + link[i][s]) : link[j][i] + link[i][s];
                }

        for (int i = 1; i <=n; i++) {
            for (int j = 1 ; j <= n; j++)
                bw.write((i == j ? "0" : link[i][j]) + " ");
            bw.newLine();
        }


        bw.flush();
        bw.close();
    }

}







