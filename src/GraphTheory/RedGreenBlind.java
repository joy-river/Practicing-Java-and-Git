package GraphTheory;

import java.io.*;
import java.util.*;

public class RedGreenBlind {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[][] table = new String[n + 1][n];

        for (int i = 1 ; i <= n ; i ++)
            table[i] = br.readLine().split("");
        Bfs(n, table);
        Bfs(n, table);

        bw.flush();
        bw.close();
    }

    static void Bfs(int n , String[][] table) throws IOException {
        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<index> next = new LinkedList<>();
        index temp;
        String color;
        int count = 0;

        for (int i = 1;  i <= n; i++){
            for (int j = 0; j < n ; j++){
                if(!visited[i][j]){
                    count++;
                    color = table[i][j];
                    visited[i][j] = true;
                    next.add(new index(i, j));

                    while(!next.isEmpty()){
                        temp = next.poll();
                        if(table[temp.i][temp.j].equals(color)) {
                            if(color.equals("G"))
                                table[temp.i][temp.j] = "R";

                            if (temp.i < n)
                                if (!visited[temp.i + 1][temp.j]) {
                                    visited[temp.i + 1][temp.j] = true;
                                    next.add(new index(temp.i + 1, temp.j));
                                }
                            if (temp.i > 1)
                                if (!visited[temp.i - 1][temp.j]) {
                                    visited[temp.i - 1][temp.j] = true;
                                    next.add(new index(temp.i - 1, temp.j));
                                }
                            if (temp.j < n - 1)
                                if (!visited[temp.i][temp.j + 1]) {
                                    visited[temp.i][temp.j + 1] = true;
                                    next.add(new index(temp.i, temp.j + 1));
                                }
                            if (temp.j > 0)
                                if (!visited[temp.i][temp.j - 1]) {
                                    visited[temp.i][temp.j - 1] = true;
                                    next.add(new index(temp.i, temp.j - 1));
                                }
                        }
                        else
                            visited[temp.i][temp.j] = false;
                    }
                }
            }
        }
        bw.write(count + " ");
    }


}
class index{
    public index(int i, int j) {
        this.i = i;
        this.j = j;
    }
    int i;
    int j;

}



