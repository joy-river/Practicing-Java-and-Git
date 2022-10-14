import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int result  = 0;
    static int[][] wire;
    public static void main(String[] args) throws IOException {
            int n = Integer.parseInt(br.readLine());
            wire = new int[n + 1][n + 1];
            node1[] tree = new node1[n + 1];
            int a, b;
            for (int i = 1; i <= n; i++)
                tree[i] = new node1(i, new ArrayList<>(), false);

            for (int i = 1 ; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                while(true) {
                    a = Integer.parseInt(st.nextToken());
                    if (a == -1)
                        break;
                    else {
                        b = Integer.parseInt(st.nextToken());
                        wire[i][a] = b;
                        wire[a][i] = b;
                        tree[i].link.add(tree[a]);
                    }
                }
            }
            for  (int i = 1; i <= n; i++)
                result = Math.max(result, dfs(tree[i]));


            bw.write(Integer.toString(result));
            bw.flush();
            bw.close();

    }
    static int dfs (node1 root){
        int temp = 0;
        if(!root.visited){
            root.visited = true;
            for (int i = 0  ; i <  root.link.size(); i++)
                if(root.link.get(i).num > root.num)
                    temp = Math.max(temp, wire[root.num][root.link.get(i).num] + dfs(root.link.get(i)));
        }
        return temp;
    }
}
class node1 {
    public node1(int num, ArrayList<node1> link, boolean visited) {
        this.num = num;
        this.link = link;
        this.visited = visited;
    }

    int num;
    ArrayList<node1> link;
    boolean visited;

}

