import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < tc; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            boolean yn = false;
            HashSet<Edge> edge = new HashSet<>();
            HashSet<Integer> start = new HashSet<>();

            int [] bell = new int[n + 1];
            int [][] weight = new int[n + 1][n + 1];
            for (int j = 1; j <= n ; j++)
                Arrays.fill(weight[j], inf);

            for (int j = 0 ; j < m + w; j++){
              st = new StringTokenizer(br.readLine());
              int u = Integer.parseInt(st.nextToken());
              int v = Integer.parseInt(st.nextToken());
              int x = Integer.parseInt(st.nextToken());

              start.add(u);
              edge.add(new Edge(u, v));

              if(j < m) {
                    edge.add(new Edge(v, u));
                  start.add(v);
                  weight[u][v] = Math.min(weight[u][v], x);
                  weight[v][u] = Math.min(weight[v][u], x);
                }

              else
                  weight[u][v] = Math.min(weight[u][v], -1 * x);
            }

            for (int begin : start){
                Arrays.fill(bell, inf);
                bell[begin] = 0;
                for (int s = 0; s <= n ; s++){
                    for (Edge value : edge) {
                        int from = value.from;
                        int to = value.to;
                        int wei = weight[from][to];
                         if (bell[from] != inf)
                            if (bell[to] > bell[from] + wei)
                                if(s == n)
                                    break;
                                else
                                    bell[to] = bell[from] + wei;
                    }
                }
                if(bell[begin] < 0) {
                        yn = true;
                        break;
                }
            }
            bw.write(yn ? "YES\n" : "NO\n");
        }


        bw.flush();
        bw.close();
    }

}

class Edge{
    int from;
    int to;
    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}





