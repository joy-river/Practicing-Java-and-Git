import java.io.*;
import java.util.*;

public class Main {
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

        int[][] visited = new int[n][m];

        int result = bfs(new Wall(0, 0, 1, false), visited, 1, 1);

        bw.write(Integer.toString(result >= max ? -1 : result));
        bw.flush();
        bw.close();
    }

    static int bfs (Wall root,  int[][] visited, int a, int b){
        Queue<Wall> next = new LinkedList<>();
        Wall temp;
        int x, y, dist, result = max;
        next.add(root);
        visited[root.x][root.y] = a;

        while (!next.isEmpty()){
            temp = next.poll();
            x = temp.x;
            y = temp.y;
            dist = temp.dist;

            if(x == n - 1 && y == m - 1) {
                result = Math.min(result, dist);
                break;
            }

            if(x > 0)
                if(visited[x - 1][y] != a && visited[x - 1][y] != b) {
                    if (table[x - 1][y].equals("0")) {
                        visited[x - 1][y] = root.Break ? b : a;
                        next.add(new Wall(x - 1, y, dist + 1, temp.Break));
                    }
                    else if(!temp.Break) {
                        result = Math.min(result, dist + bfs(new Wall(x - 1, y, 1, true), visited, a, ++b));
                        b++;
                        if(result < max)
                            break;
                    }
                }

            if(x < n - 1)
                if(visited[x + 1][y] != a && visited[x + 1][y] != b) {
                    if (table[x + 1][y].equals("0")) {
                        visited[x + 1][y] = root.Break ? b : a;
                        next.add(new Wall(x + 1, y, dist + 1, temp.Break));
                    }
                    else if (!temp.Break) {
                        result = Math.min(result, dist + bfs(new Wall(x + 1, y, 1, true), visited, a, ++b));
                        b++;
                        if(result < max)
                            break;
                    }
                }

            if(y > 0)
                if(visited[x][y - 1] != a && visited[x][y - 1] != b) {
                    if (table[x][y - 1].equals("0")) {
                        visited[x][y - 1] = root.Break ? b : a;
                        next.add(new Wall(x, y - 1, dist + 1, temp.Break));
                    }
                    else if (!temp.Break) {
                        result = Math.min(result, dist + bfs(new Wall(x, y - 1, 1, true), visited, a, ++b));
                        b++;
                        if(result < max)
                            break;
                    }

                }

            if(y < m - 1)
                if(visited[x][y + 1] != a && visited[x][y + 1] != b) {
                    if (table[x][y + 1].equals("0")) {
                        visited[x][y + 1] = root.Break ? b : a;
                        next.add(new Wall(x, y + 1, dist + 1, temp.Break));
                    }
                    else if (!temp.Break) {
                        result = Math.min(result, dist + bfs(new Wall(x, y + 1, 1, true), visited, a, ++b));
                        b++;
                        if(result < max)
                            break;
                    }
                }
        }
        return result;
    }
}
class Wall {
    int x;
    int y;
    int dist;
    boolean Break;

    public Wall( int x, int y, int dist, boolean Break) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.Break = Break;
    }
}





