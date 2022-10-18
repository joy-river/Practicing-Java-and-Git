import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int inf = 50000000;

    public static void main(String[] args) throws IOException {
       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
        int [][] weight = new int[n + 1][n + 1];
        int [] dij = new int[n + 1];

        int start = Integer.parseInt(br.readLine());
        int u, v, w;
        PriorityQueue<Integer> next = new PriorityQueue<>(Comparator.comparingInt(o -> dij[o]));
        ArrayList[] link = new ArrayList[n + 1];


        for (int i = 1 ; i <= n; i ++){
            link[i] = new ArrayList<Integer>();
            dij[i] = inf;
        }

        for (int i = 0 ; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            weight[u][v] = w;
            weight[v][u] = w;
            link[u].add(v);
            link[v].add(u);
        }


        next.add(start);

        while(!next.isEmpty()){

        }




        bw.write();
        bw.flush();
        bw.close();

    }

}

