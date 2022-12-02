package GraphTheory;

import java.io.*;
import java.util.*;

public class Cheese {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n , m;
    static String[][] input;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new String[n][];
        for (int i = 0 ; i < n ; i++)
            input[i] = br.readLine().split(" ");

        bw.write(Integer.toString(melt()));
        bw.flush();
        bw.close();
    }

    static int melt(){
        HashSet<Index> entry = new HashSet<>();
        int[][] visited = new int[n][m];
        int x = 0, y = 0, time = 0;

        while(true){
            bfs(-1 * time, entry, visited);
            if(entry.isEmpty())
                break;

            for(Index a : entry){
                x = a.x;
                y = a.y;
                if(visited[x][y] > 1) {
                    input[x][y] = "0";
                    visited[x][y] = -1 * time - 1;
                }
                else
                    visited[x][y] = 0;
            }
            entry.clear();
            time++;
        }

        return time;
    }
    static void bfs(int time, HashSet<Index> entry, int[][] visited) {
        Queue<Index> next = new LinkedList<>();
        next.add(new Index(0, 0));
        visited[0][0] = time;
        int x, y;
        Index temp;
        while (!next.isEmpty()) {
            temp = next.poll();
            x = temp.x;
            y = temp.y;

            if (x > 0)
                if (input[x - 1][y].equals("0")) {
                    if (visited[x - 1][y] >= time) {
                        visited[x - 1][y] = time - 1;
                        next.add(new Index(x - 1, y));
                    }
                }
                else {
                    visited[x - 1][y]++;
                    entry.add(new Index(x - 1, y));
                }


            if (x < n - 1)
                if (input[x + 1][y].equals("0")) {
                    if (visited[x + 1][y] >= time) {
                        visited[x + 1][y] = time - 1;
                        next.add(new Index(x + 1, y));
                    }
                }
                else {
                    visited[x + 1][y]++;
                    entry.add(new Index(x + 1, y));
                }

            if (y > 0)
                if (input[x][y - 1].equals("0")) {
                    if (visited[x][y - 1] >= time) {
                        visited[x][y - 1] = time - 1;
                        next.add(new Index(x, y - 1));
                    }
                } else {
                    visited[x][y - 1]++;
                    entry.add(new Index(x, y - 1));
                }

            if (y < m - 1)
                if (input[x][y + 1].equals("0")) {
                    if (visited[x][y + 1] >= time) {
                        visited[x][y + 1] = time - 1;
                        next.add(new Index(x, y + 1));
                    }
                } else {
                    visited[x][y + 1]++;
                    entry.add(new Index(x, y + 1));
                }
        }
    }

}
class Index {
    int x;
    int y;

    public Index(int x, int y) {
        this.x = x;
        this.y = y;
    }
}







