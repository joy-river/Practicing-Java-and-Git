package DFSandBFS;

import java.io.*;
import java.util.*;

public class BreakingWall {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static final int max = 100000000;
    static String[][] table;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        table = new String[n][];

        for (int i = 0; i < n; i++)
            table[i] = br.readLine().split("");


        int result = bfs(new Wall(0, 0, 1, 0));

        bw.write(Integer.toString(result >= max ? -1 : result));
        bw.flush();
        bw.close();
    }

    static int bfs (Wall root){
        Queue<Wall> next = new LinkedList<>();
        boolean [][][] visited = new boolean[n][m][2];

        Wall temp;
        int x, y, dist, Break, result = max;
        next.add(root);
        visited[0][0][0] = true;

        while (!next.isEmpty()){
            temp = next.poll();
            x = temp.x;
            y = temp.y;
            Break = temp.Break;
            dist = temp.dist;

            if(x == n - 1 && y == m - 1) {
                result = Math.min(result, dist);
                break;
            }

            if(x > 0)
                if (table[x - 1][y].equals("0")) {
                    if (!visited[x - 1][y][Break]) {
                        visited[x - 1][y][Break] = true;
                        next.add(new Wall(x - 1, y, dist + 1, Break));
                    }
                }
                else if (Break != 1)
                    if(!visited[x - 1][y][1]){
                        visited[x - 1][y][1] = true;
                        next.add(new Wall(x - 1, y, dist + 1, 1));
                    }

            if(x < n - 1)
                if (table[x + 1][y].equals("0")) {
                    if (!visited[x + 1][y][Break]) {
                        visited[x + 1][y][Break] = true;
                        next.add(new Wall(x + 1, y, dist + 1, Break));
                    }
                }
                else if (Break != 1)
                    if(!visited[x + 1][y][1]){
                        visited[x + 1][y][1] = true;
                        next.add(new Wall(x + 1, y, dist + 1, 1));
                    }

            if(y > 0)
                if (table[x][y - 1].equals("0")) {
                    if (!visited[x][y - 1][Break]) {
                        visited[x][y - 1][Break] = true;
                        next.add(new Wall(x, y - 1, dist + 1, Break));
                    }
                }
                else if (Break != 1)
                    if(!visited[x][y - 1][1]){
                        visited[x][y - 1][1] = true;
                        next.add(new Wall(x, y - 1, dist + 1, 1));
                    }

            if(y < m - 1)
                if (table[x][y + 1].equals("0")) {
                    if (!visited[x][y + 1][Break]) {
                        visited[x][y + 1][Break] = true;
                        next.add(new Wall(x, y + 1, dist + 1, Break));
                    }
                }
                else if (Break != 1)
                    if(!visited[x][y + 1][1]){
                        visited[x][y + 1][1] = true;
                        next.add(new Wall(x, y + 1, dist + 1, 1));
                    }
        }
        return result;
    }
}
class Wall {
    int x;
    int y;
    int dist;
    int Break;

    public Wall( int x, int y, int dist, int Break) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.Break = Break;
    }
}





