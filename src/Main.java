import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b;
        int [][] link = new int[n + 1][n + 1];
        for (int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            link[a][b] = 1;
            link[b][a] = 1;
        }
        for (int )

        bw.flush();
        bw.close();
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



