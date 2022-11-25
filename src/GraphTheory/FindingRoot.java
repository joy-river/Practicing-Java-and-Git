package GraphTheory;

import java.io.*;
import java.util.*;

public class FindingRoot {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int a, b;
        Queue<FindRoot> find = new LinkedList<>();
        FindRoot[] node = new FindRoot[n + 1];
        FindRoot temp;

        for (int i = 1 ; i <= n ;i ++)
            node[i] = new FindRoot(i, 0, false, new ArrayList<>());

        for (int i = 1 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            node[a].link.add(node[b]);
            node[b].link.add(node[a]);
        }
        node[1].visited = true;
        find.add(node[1]);

        while(!find.isEmpty()){
            for (int i = 0 ; i < find.peek().link.size() ; i++){
                temp = find.peek().link.get(i);
                if(!temp.visited){
                    temp.parent = find.peek().num;
                    temp.visited = true;
                    find.add(temp);
                }
            }
            find.poll();
        }
        for (int i = 2; i <= n ; i++)
            bw.write(node[i].parent + "\n");

        bw.flush();
        bw.close();
    }

}
class FindRoot{
    public FindRoot(int num, int parent, boolean visited, ArrayList<FindRoot> link) {
        this.num = num;
        this.parent = parent;
        this.visited = visited;
        this.link = link;
    }

    int num;
    int parent;
    boolean visited;
    ArrayList<FindRoot> link;
}







