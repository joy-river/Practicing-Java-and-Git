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

       int [] dij = new int[n + 1];

       int u, v, w;
       PriorityQueue<node3> next = new PriorityQueue<>(Comparator.comparingInt(o -> dij[o.num]));
       node3[] nodes = new node3[n + 1];


        for (int i = 1 ; i <= n; i ++){
            nodes[i] = new node3(i, new ArrayList<>(), new ArrayList<>(), false);
            dij[i] = inf;
        }

        for (int i = 0 ; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
           nodes[u].link.add(nodes[v]);
           nodes[u].weight.add(w);
           nodes[v].link.add(nodes[u]);
           nodes[v].weight.add(w);
        }
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        dij[start] = 0;
        next.add(nodes[start]);

        while(!next.isEmpty()){
            if(!next.peek().visited) {
                node3 root = next.poll();
                for (int i = 0; i < root.link.size(); i++) {
                    dij[root.link.get(i).num] = Math.min(dij[root.link.get(i).num], dij[root.num] + root.weight.get(i));
                    next.add(root.link.get(i));
                }
                root.visited = true;
            }
            else
                next.poll();
        }


        bw.write(dij[dest] == inf ? "-1\n" : dij[dest] + "\n");

        bw.flush();
        bw.close();

    }
}
class node3 {
    public node3(int num, ArrayList<node3> link, ArrayList<Integer> weight, boolean visited) {
        this.num = num;
        this.link = link;
        this.weight = weight;
        this.visited = visited;
    }

    int num;
    ArrayList<node3> link;
    ArrayList<Integer> weight;
    boolean visited;

}


