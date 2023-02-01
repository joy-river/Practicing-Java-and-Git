package GraphTheory;

import java.io.*;
import java.util.*;


public class SeperatingCityPlan_Alt {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b, c, cost = 0, Max_Cost = 0;
        Prim_Edge temp;
        PriorityQueue<Prim_Edge> next = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));
        Queue<Prim_Edge>[] vertex = new Queue[n + 1];

        for (int i = 1 ; i <= n; i ++)
            vertex[i] = new LinkedList<>();

        for (int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            vertex[a].add(new Prim_Edge(a, b, c));
            vertex[b].add(new Prim_Edge(b, a, c));
        }
        next.add(new Prim_Edge(0, 1, 0));

        while(!next.isEmpty()){
            temp = next.poll();
            if(!vertex[temp.to].isEmpty()) {
                cost += temp.cost;
                Max_Cost = Math.max(Max_Cost, temp.cost);
                while (!vertex[temp.to].isEmpty())
                    next.add(vertex[temp.to].poll());
            }
        }

        bw.write(Integer.toString(cost - Max_Cost));
        bw.flush();
        bw.close();
    }


}
class Prim_Edge {
    int from, to, cost;

    public Prim_Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}






