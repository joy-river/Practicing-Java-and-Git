import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int first , last;
        ArrayList<node> graph = new ArrayList<>();
        for (int i = 1 ; i <= n ; i++)
            graph.add(new node(i, false));
        for (int i = 0 ; i < m ; i ++){
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken()) - 1;
            last =  Integer.parseInt(st.nextToken()) - 1;
            graph.get(first).link.add(graph.get(last));
        }
        dfs(graph.get(v - 1));

        bw.flush();
        bw.close();
    }
    static void dfs(node root){

    }
    static void bfs(){}

}
class node {
    PriorityQueue<node> link = new PriorityQueue<>(Comparator.comparingInt(o -> o.n));
    public node(int n, boolean checked) {
        this.n = n;
        this.checked = checked;
    }
    int n;
    boolean checked = false;

}



