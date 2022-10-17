import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        node1[] tree = new node1[n + 1];
        int temp, a, b, result = 0;
        for (int i = 1; i <= n; i++)
            tree[i] = new node1(i, new ArrayList<>(), new ArrayList<>(), false);

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            temp = Integer.parseInt(st.nextToken());
            while (true) {
                a = Integer.parseInt(st.nextToken());
                if (a == -1)
                    break;
                else {
                    b = Integer.parseInt(st.nextToken());
                    tree[temp].weight.add(b);
                    tree[a].weight.add(b);
                    tree[temp].link.add(tree[a]);
                    tree[a].link.add(tree[temp]);
                }
            }
        }
        for (int i = 1; i <= n; i++)
            if (!tree[i].visited)
                result = Math.max(result, init(tree[i]));


        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();

    }

    static int init (node1 root){
        int temp = 0;
        root.visited = true;
        for (int i = 0; i < root.link.size(); i++){
            if(!root.link.get(i).visited){
                temp += root.weight.get(i) + dfs(root.link.get(i));
            }
        }
        return temp;
    }
    static int dfs (node1 root){
        int temp = 0;
        if(!root.visited){
            root.visited = true;
            for (int i = 0  ; i < root.link.size(); i++)
                if(!root.link.get(i).visited)
                    temp = Math.max(temp, root.weight.get(i) + dfs(root.link.get(i)));
        }
        return temp;
    }
}
class node1 {
    public node1(int num, ArrayList<node1> link, ArrayList<Integer> weight, boolean visited) {
        this.num = num;
        this.link = link;
        this.weight = weight;
        this.visited = visited;
    }

    int num;
    ArrayList<node1> link;
    ArrayList<Integer> weight;
    boolean visited;

}

