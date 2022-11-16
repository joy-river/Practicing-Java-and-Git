import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static String[] in;
    static String[] post;
    static Travel[] tree;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        in = br.readLine().split(" ");
        post = br.readLine().split(" ");
        tree = new Travel[n + 1];
        int root = Integer.parseInt(post[post.length - 1]);
        Travel a = tree[root]  = new Travel(root, null, null, null);

        MakeTree(tree[root], 0 , n);


        bw.write(pre(a));
        bw.flush();
        bw.close();
    }
    static void MakeTree(Travel root, int start, int end){
        int  left = 0, right = 0, temp;

        if(start >= end)
            return;

        for (int i = start ; i < end ; i ++)
            if(Integer.parseInt(in[i]) == root.init) {
                left = i;
                right = end - i - 1;
                break;
            }
           if(left > start) {
                temp = Integer.parseInt(post[left - 1]);
                tree[temp] = new Travel(temp, root, null, null);
                root.left = tree[temp];
               MakeTree(tree[temp], start, left);
          }
            if(right > 0) {
                temp = Integer.parseInt(post[right + left - 1]);
                tree[temp] = new Travel(temp, root, null, null);
                root.right = tree[temp];
                MakeTree(tree[temp], left + 1, end);
            }
    }

    static String pre(Travel root){
        String temp = "";

        temp += root.init + " ";

        if(root.left != null)
            temp += pre(root.left);

        if(root.right != null)
            temp += pre(root.right);

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




