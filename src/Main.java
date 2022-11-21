import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static String[][] table

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        table = new String[n][];

        for (int i = 0; i < n; i++)
            table[i] = br.readLine().split("");




        if(!found)
            bw.write("-1");
        bw.flush();
        bw.close();
    }

    static int bfs (Wall root){
        boolean[][] visited = new boolean[n][m];
        Queue<Wall> next = new LinkedList<>();
        Wall temp;
        int x, y, result = 0
                ;
        next.add(root);

        while (!next.isEmpty()){
            temp = next.poll();
            x = temp.x;
            y = temp.y;

            if(x == 0 && y == 0){

            }


        }

    }


}
class Wall {
    int x;
    int y;
    int dist;

    public Wall( int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}





