import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int size = 2, count = 0;
        fish shark;
        String [][] pool = new String[n][];


        for (int i = 0; i < n ; i ++)
            pool[i] = br.readLine().split(" ");

        for (int i = 0 ; i < n ; i ++)
            for (int j = 0 ; j < n ; j ++){
                if(pool[i][j].equals("9")) {
                    shark = new fish(i, j, 0, 2);
                    Findfish()
                    break;
                }

            }








        bw.flush();
        bw.close();
    }
    static void Findfish(fish shark, String[][] pool, int time, int count){
        PriorityQueue<fish> eat = new PriorityQueue<>((o1, o2) -> {
            if(o1.dist != o2.dist)
                return Integer.compare(o1.dist, o2.dist);
            else
            if(o1.i == o2.i)
                return Integer.compare(o1.j, o2.j);
            else
                return Integer.compare(o1.i, o2.i);
        });
        Queue<fish> bfs = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        fish temp;
        int i, j, dist = 1;
        bfs.add(shark);
        while(!bfs.isEmpty()){
            temp = bfs.poll();
            i = temp.i;
            j = temp.j;
            visited[i][j] = true;
            if()

            if(i > 0){
                if(!visited[i -1][j])
                    bfs.add(new fish(i - 1, j, dist, 0));
            }

            if(i < n - 1){
                if(!visited[i + 1][j])
            }
            if(j > 0){
                if(!visited[i][j - 1])
            }
            if(j < n - 1){
                if(!visited[i][j + 1])
            }

        }




    }

}
class fish{
    int i;
    int j;
    int dist;
    int size;

    public fish(int i, int j, int dist, int size) {
        this.i = i;
        this.j = j;
        this.dist = dist;
        this.size = size;
    }
}


