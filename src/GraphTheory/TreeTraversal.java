package GraphTheory;

import java.io.*;
import java.util.*;

public class TreeTraversal {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int root, temp;


        travel[] tree = new travel[n];
        for (int i = 0 ; i < n ; i ++)
            tree[i] = new travel(i, null, null, null);
        for (int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            root = st.nextToken().charAt(0) - 65;
            temp = st.nextToken().charAt(0) - 65;
            if(temp >= 0){
                tree[root].left = tree[temp];
                tree[temp].parent = tree[root];
            }
            temp = st.nextToken().charAt(0) - 65;
            if(temp >= 0) {
                tree[root].right = tree[temp];
                tree[temp].parent = tree[root];
            }
        }
        bw.write(pre(tree, 0) + "\n" + in(tree, 0) + "\n" + post(tree, 0));


        bw.flush();
        bw.close();
    }
    static String pre(travel[] tree, int root){
        String temp = "";

        temp += (char)(root +65);

        if(tree[root].left != null)
            temp += pre(tree, tree[root].left.init);

        if(tree[root].right != null)
            temp += pre(tree, tree[root].right.init);

        return temp;
    }
    static String in(travel[] tree, int root){
        String temp = "";

        if(tree[root].left != null)
            temp += in(tree, tree[root].left.init);

        temp += (char)(root + 65);

        if(tree[root].right != null)
            temp += in(tree, tree[root].right.init);
        return temp;
    }
    static String post(travel[] tree, int root){
        String temp = "";
        if(tree[root].left != null)
            temp += post(tree, tree[root].left.init);

        if(tree[root].right != null)
            temp += post(tree, tree[root].right.init);

        temp += (char)(root+65);
        return temp;
    }

}
class travel {
    int init;
    travel parent;
    travel left;
    travel right;

    public travel(int init, travel parent, travel left, travel right) {
        this.init = init;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}




