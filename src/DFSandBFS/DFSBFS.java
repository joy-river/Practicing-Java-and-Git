package DFSandBFS;

import java.io.*;
import java.util.*;

public class DFSBFS {
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
            graph.get(last).link.add(graph.get(first));
        }
        dfs(graph.get(v - 1));
        bw.write("\n");
        bfs(graph.get(v - 1));
        bw.flush();
        bw.close();
    }
    static void dfs(node root) throws IOException {
        bw.write(root.n +" ");
        root.checked = true;
        root.sort();
        int n = root.link.size();
        for (int i = 0 ; i < n ; i ++)
            if(!root.link.get(i).checked)
                dfs(root.link.get(i));

    }
    static void bfs(node root) throws IOException {
        Queue<node> bfs = new LinkedList<>();
        bfs.add(root);
        while(!bfs.isEmpty())
            if(!bfs.peek().checked)
                bfs.poll();
            else{
                bfs.peek().checked = false;
                bw.write(bfs.peek().n + " ");
                bfs.addAll(bfs.poll().link);
            }

    }

}
class node {
    ArrayList<node> link = new ArrayList<>();
    public node(int n, boolean checked) {
        this.n = n;
        this.checked = checked;
    }
    public void sort() {
        Collections.sort(this.link, Comparator.comparingInt(o -> o.n));
    }
    int n;
    boolean checked = false;

}




