import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b, count = 0;
        node[] list = new node[n + 1];
        Queue<node> bfs = new LinkedList<>();
        for (int i = 1; i <= n ; i++)
            list[i] = new node(i,false, new ArrayList<>());

        for (int i = 0 ; i < m ; i++){
            st =  new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list[a].link.add(list[b]);
            list[b].link.add(list[a]);
        }

        for (int i = 1; i <= n; i++)
            if(!list[i].visited){
                list[i].visited = true;
                bfs.addAll(list[i].link);
                while(!bfs.isEmpty())
                    if(!bfs.peek().visited){
                        bfs.peek().visited = true;
                        bfs.addAll(bfs.poll().link);
                    }
                    else
                        bfs.poll();
                count++;
            }




        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();

    }
}
class node{
    public node(int num, boolean visited, ArrayList<node> link) {
        this.num = num;
        this.visited = visited;
        this.link = link;
    }

    int num;
    boolean visited;
    ArrayList<node> link;
}

