package GraphTheory;

import java.io.*;
import java.util.*;

public class Virus {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int InitSize, safe = 0;
        pos a, b, c;
        ArrayList<pos> virus = new ArrayList<>();
        Queue<pos> empty = new LinkedList<>();
        String[][] table = new String[n][];
        for (int i = 0 ; i < n ; i ++)
            table[i] = br.readLine().split(" ");

        for (int i = 0 ; i < n ; i ++){
            for (int j = 0 ; j < m ; j++){
                if(table[i][j].equals("2"))
                    virus.add(new pos(i, j));
                else if (table[i][j].equals("0"))
                    empty.add(new pos(i, j));
            }
        }
        InitSize = empty.size();

        while(empty.size() > 2){
            a = empty.poll();
            table[a.x][a.y] = "1";
            for (int i = 0 ; i < empty.size(); i++){
                b = empty.poll();
                table[b.x][b.y] = "1";
                for (int j = 0 ; j < empty.size();j++){
                    c = empty.poll();
                    table[c.x][c.y] = "1";
                    safe = Math.max(safe, InitSize - 3 - bfs(table, virus));
                    table[c.x][c.y] = "0";
                    empty.add(c);
                }
                table[b.x][b.y] = "0";
                empty.add(b);
            }
            table[a.x][a.y] = "0";
        }

        bw.write(Integer.toString(safe));
        bw.flush();
        bw.close();
    }
    static int bfs(String[][] table, ArrayList<pos> virus){
        boolean[][] visited = new boolean[n][m];
        Queue<pos> next = new LinkedList<>(virus);
        pos temp;
        int x, y, count = 0;
        while(!next.isEmpty()){
            temp = next.poll();
            x = temp.x;
            y = temp.y;
            visited[x][y] = true;
            if(x > 0){
                if(!visited[x - 1][y]) {
                    if (table[x - 1][y].equals("0")){
                        next.add(new pos(x - 1, y));
                        count++;
                    }
                    visited[x - 1][y] = true;
                }
            }
            if(x < n - 1){
                if(!visited[x + 1][y]) {
                    if (table[x + 1][y].equals("0")){
                        next.add(new pos(x + 1, y));
                        count++;
                    }
                    visited[x + 1][y] = true;
                }
            }
            if(y > 0){
                if(!visited[x][y - 1]) {
                    if (table[x][y - 1].equals("0")){
                        next.add(new pos(x, y - 1));
                        count++;
                    }
                    visited[x][y - 1] = true;
                }
            }
            if(y < m - 1){
                if(!visited[x][y + 1]) {
                    if (table[x][y + 1].equals("0")){
                        next.add(new pos(x, y + 1));
                        count++;
                    }
                    visited[x][y + 1] = true;
                }
            }
        }
        return count;
    }

}
class pos{
    int x, y;
    public pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}






