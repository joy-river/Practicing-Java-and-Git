package Simulation;

import java.io.*;
import java.util.*;

public class GoodByeMimun {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, c, t;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        String [][] table = new String[r][];
        for (int i = 0 ; i < r ; i++)
            table[i] = br.readLine().split(" ");

        bw.write(Integer.toString(MiMun(table)));
        bw.flush();
        bw.close();
    }
    static int MiMun(String[][] table) {
        Dust puri = null;
        Queue<Dust> dust = new LinkedList<>();
        int count = 0, sum = 0;
        int[][] a = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = Integer.parseInt(table[i][j]);
                if (a[i][j] == -1) {
                    if (puri == null)
                        puri = new Dust(i, j);
                } else if (a[i][j] != 0)
                    dust.add(new Dust(i, j));
            }
        }

        while(count < t){
            a = diff(a, dust, puri);
            a = flow(a, dust, puri);
            count++;
        }

        for(Dust temp : dust)
            sum += a[temp.x][temp.y];
        return sum;

    }
    static int[][] diff(int[][] a, Queue<Dust> dust, Dust puri){
        int x, y, x1 = puri.x, x2 = x1 + 1;
        int count;
        int size = dust.size();
        int [][] b = new int[r][c];
        boolean [][] visited = new boolean[r][c];
        Dust temp;

        for(int i = 0 ; i < size; i ++){
            temp = dust.poll();
            x = temp.x;
            y = temp.y;
            count = 0;
            if (a[x][y] > 4) {
                if (x > 0) {
                    if (y != 0 || x - 1 != x2) {
                        b[x - 1][y] += a[x][y] / 5;
                        if (!visited[x - 1][y]) {
                            visited[x - 1][y] = true;
                            dust.add(new Dust(x - 1, y));
                        }
                        count++;
                    }
                }

                if (x < r - 1) {
                    if (y != 0 || x + 1 != x1) {
                        b[x + 1][y] += a[x][y] / 5;
                        if (!visited[x + 1][y]) {
                            visited[x + 1][y] = true;
                            dust.add(new Dust(x + 1, y));
                        }
                        count++;
                    }
                }

                if (y > 0) {
                    if (y - 1 != 0 || (x != x1 && x != x2)) {
                        b[x][y - 1] += a[x][y] / 5;
                        if (!visited[x][y - 1]) {
                            visited[x][y - 1] = true;
                            dust.add(new Dust(x, y - 1));
                        }
                        count++;
                    }
                }
                if (y < c - 1) {
                    b[x][y + 1] += a[x][y] / 5;
                    if (!visited[x][y + 1]) {
                        visited[x][y + 1] = true;
                        dust.add(new Dust(x, y + 1));
                    }
                    count++;
                }
            }
            b[x][y] += a[x][y] - count * (a[x][y] / 5);
            if(!visited[x][y]){
                visited[x][y] = true;
                dust.add(temp);
            }
        }
        return b;
    }
    static int[][] flow(int [][] a, Queue<Dust> dust, Dust puri){
        int x1 = puri.x, x2 = x1 + 1;
        int x, y;
        int [][] b = new int[r][c];
        int i = 0, size = dust.size();
        Dust next;

        while (i < size){
            next = dust.poll();
            x = next.x;
            y = next.y;
            if(y == 0){
                if (x < x1 && x + 1 != x1) {
                    b[x + 1][y] = a[x][y];
                    dust.add(new Dust(x + 1, y));
                }
                if (x > x2 && x - 1 != x2) {
                    b[x - 1][y] = a[x][y];
                    dust.add(new Dust(x - 1, y));
                }
            }
            else if (y == c - 1){
                if(x == 0 || x == r- 1){
                    b[x][y - 1] = a[x][y];
                    dust.add(new Dust(x, y - 1));
                }
                else if(x >= x2){
                    if(x  < r - 1){
                        b[x + 1][y] = a[x][y];
                        dust.add(new Dust(x + 1, y));
                    }
                }
                else if(x <= x1) {
                    if (x > 0){
                        b[x - 1][y] = a[x][y];
                        dust.add(new Dust(x - 1, y));
                    }
                }
            }
            else if (x == 0 || x == r - 1){
                b[x][y - 1] = a[x][y];
                dust.add(new Dust(x, y- 1));
            }
            else if (x == x1 || x == x2){
                b[x][y + 1] = a[x][y];
                dust.add(new Dust(x, y + 1));
            }
            else{
                b[x][y] = a[x][y];
                dust.add(new Dust(x, y));
            }
            i++;
        }
        return b;
    }
}
class Dust {
    int x;

    public Dust(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int y;
}







