package DFSandBFS;

import java.io.*;
import java.util.*;

public class TreeDiameter2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static node2[] tree;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        tree = new node2[n + 1];
        int temp, a, b;
        for (int i = 0; i <= n; i++)
            tree[i] = new node2(i, new ArrayList<>(), new ArrayList<>(), false, 0);

        for (int i = 1 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            temp = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            tree[temp].weight.add(b);
            tree[a].weight.add(b);
            tree[temp].link.add(tree[a]);
            tree[a].link.add(tree[temp]);
        }

        dfs(tree[1], 0);
        for (int i = 0 ; i <= n ; i ++)
            tree[i].visited = false;
        dfs(tree[0], temp = tree[0].sum);


        bw.write(Integer.toString(tree[0].sum - temp));
        bw.flush();
        bw.close();

    }
    static void dfs (node2 root, int sum){
        root.visited = true;
        root.sum = sum;
        if(tree[0].sum < sum)
            tree[0] = root;
        for (int i = 0  ; i < root.link.size(); i++)
            if(!root.link.get(i).visited)
                dfs(root.link.get(i), sum + root.weight.get(i));

    }
}
class node2 {
    public node2(int num, ArrayList<node2> link, ArrayList<Integer> weight, boolean visited, int sum) {
        this.num = num;
        this.link = link;
        this.weight = weight;
        this.visited = visited;
        this.sum = sum;
    }

    int num;
    ArrayList<node2> link;
    ArrayList<Integer> weight;
    boolean visited;
    int sum;

}


