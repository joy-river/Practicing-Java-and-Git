import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int a, b;
        long [][] cost = new long [n + 1][n + 1];
        long [] dij = new long[n + 1];


        for (int i = 1; i <= n ; i++)
            for (int j = 1; j <= n ; j++)
                cost[i][j] = m * 100000L + 1;

        for (int i = 0 ; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost[a][b] = Math.min(cost[a][b], Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());


        bw.write();
        bw.flush();
        bw.close();
    }

}









