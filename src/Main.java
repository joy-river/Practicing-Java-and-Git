import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        String[] post = br.readLine().split(" ");





        bw.flush();
        bw.close();
    }
    static void MakeTree(String[] in, String[] post, int n){
        Travel[] tree = new Travel[n + 1];
        int root = Integer.parseInt(post[post.length - 1]);
        tree[root]  = new Travel(root, null, null, null);

        int temp = 0;
        tree[Integer.parseInt(in[temp])] = new Travel(Integer.parseInt(in[temp]), null, null,null);

        for (int i = 1; i < n; i ++) {
            if(Integer.parseInt(in[i]) == root)
                break;





        }



    }
    static String pre(Travel[] tree, int root){
        String temp = "";

        temp += (char)(root +65);

        if(tree[root].left != null)
            temp += pre(tree, tree[root].left.init);

        if(tree[root].right != null)
            temp += pre(tree, tree[root].right.init);

        return temp;
    }
    static String in(Travel[] tree, int root){
        String temp = "";

        if(tree[root].left != null)
            temp += in(tree, tree[root].left.init);

        temp += (char)(root + 65);

        if(tree[root].right != null)
            temp += in(tree, tree[root].right.init);
        return temp;
    }
    static String post(Travel[] tree, int root){
        String temp = "";
        if(tree[root].left != null)
            temp += post(tree, tree[root].left.init);

        if(tree[root].right != null)
            temp += post(tree, tree[root].right.init);

        temp += (char)(root+65);
        return temp;
    }

}
class Travel {
    int init;
    Travel parent;
    Travel left;
    Travel right;

    public Travel(int init, Travel parent, Travel left, Travel right) {
        this.init = init;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}




