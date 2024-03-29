package GraphTheory;

import java.io.*;
import java.util.*;

public class BabyShark {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        fish shark;
        String [][] pool = new String[n][];
        boolean stop = false;


        for (int i = 0; i < n ; i ++)
            pool[i] = br.readLine().split(" ");

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0; j < n; j++) {
                if (pool[i][j].equals("9")) {
                    shark = new fish(i, j, 0, 2);
                    bw.write(Integer.toString(Findfish(shark, pool, 0)));
                    stop = true;
                    break;
                }
            }
            if(stop)
                break;
        }






        bw.flush();
        bw.close();
    }
    static int Findfish(fish shark, String[][] pool, int count){
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
        int i, j, dist, size;

        bfs.add(shark);

        while(!bfs.isEmpty()){
            temp = bfs.poll();
            i = temp.i;
            j = temp.j;
            dist = temp.dist;
            size = temp.size;

            if(!eat.isEmpty()){
                if(dist > eat.peek().dist)
                    break;
            }

            if(size > 0 && size < 9){
                if (shark.size > size)
                    eat.add(temp);

            }

            if(shark.size >= size) {
                if (i > 0) {
                    if (!visited[i - 1][j]) {
                        visited[i - 1][j] = true;
                        bfs.add(new fish(i - 1, j, dist + 1, Integer.parseInt(pool[i - 1][j])));
                    }
                }

                if (i < n - 1) {
                    if (!visited[i + 1][j]) {
                        visited[i + 1][j] = true;
                        bfs.add(new fish(i + 1, j, dist + 1, Integer.parseInt(pool[i + 1][j])));
                    }
                }
                if (j > 0) {
                    if (!visited[i][j - 1]) {
                        visited[i][j - 1] = true;
                        bfs.add(new fish(i, j - 1, dist + 1, Integer.parseInt(pool[i][j - 1])));
                    }
                }
                if (j < n - 1) {
                    if (!visited[i][j + 1]) {
                        visited[i][j + 1] = true;
                        bfs.add(new fish(i, j + 1, dist + 1, Integer.parseInt(pool[i][j + 1])));
                    }
                }
            }

        }
        if(eat.isEmpty())
            return 0;
        else{
            temp = eat.poll();
            pool[temp.i][temp.j] = "9";
            pool[shark.i][shark.j] = "0";
            if(count + 1 == shark.size) {
                shark.size++;
                count = -1;
            }
            shark.i = temp.i;
            shark.j = temp.j;
            return temp.dist + Findfish(shark, pool, count + 1);
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


