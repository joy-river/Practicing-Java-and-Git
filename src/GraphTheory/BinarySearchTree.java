package GraphTheory;

import java.io.*;
import java.util.*;

public class BinarySearchTree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        String a;
        while ((a = br.readLine()) != null)
            list.add(Integer.parseInt(a));

        Tree(list, 0, list.size() - 1);

        bw.flush();
        bw.close();
    }
    static void Tree(ArrayList<Integer> list, int start, int end) throws IOException {
        int root = list.get(start);
        int i = start + 1;

        if(start >= end)
            bw.write(root + "\n");
        else {
            while (i <= end) {
                if (root < list.get(i)) {
                    if(i > start + 1)
                        Tree(list, start + 1, i - 1);
                    Tree(list, i, end);
                    break;
                }
                else
                    i++;
            }
            if(i == end + 1)
                Tree(list, start + 1, i - 1);
            bw.write(root + "\n");
        }

    }
}









