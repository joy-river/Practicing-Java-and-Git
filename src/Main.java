import java.io.*;
import java.util.*;

public class Main {
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
        ArrayList<Dust> dust = new ArrayList<>();
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
    static int[][] diff(int[][] a, ArrayList<Dust> dust, Dust puri){
        int x, y, x1 = puri.x, x2 = x1 + 1;
        int count;
        int [][] b = new int[r][c];

        for (Dust value : dust) {
            x = value.x;
            y = value.y;
            count = 0;
            if (x > 0) {
                if (y != 0 || x - 1 != x2) {
                    b[x - 1][y] += a[x][y] / 5;
                    count++;
                }
            }
            if (x < r - 1) {
                if (y != 0 || x + 1 != x1) {
                    b[x + 1][y] += a[x][y] / 5;
                    count++;
                }
            }
            if (y > 0) {
                if (y - 1 != 0 || (x != x1 && x != x2)) {
                    b[x][y - 1] += a[x][y] / 5;
                    count++;
                }
            }
            if (y < c - 1) {
                b[x][y + 1] += a[x][y] / 5;
                count++;
            }
            b[x][y] += a[x][y] - count * (a[x][y] / 5);
        }
        dust.clear();
        for (int i = 0 ; i < r ; i ++)
            for (int j = 0; j < c; j ++)
                if(b[i][j] != 0)
                    dust.add(new Dust(i, j));
        return b;
    }
    static int[][] flow(int [][] a, ArrayList<Dust> dust, Dust puri){
        int x1 = puri.x, x2 = x1 + 1;
        int x, y;
        int [][] b = new int[r][c];
        int i = 0, size = dust.size();
        Dust next;

        while (i < size){
            next = dust.remove(0);
            x = next.x;
            y = next.y;
            if(y == 0){
                if(x < x1){
                    if(x + 1 != x1){
                        b[x + 1][y] = a[x][y];
                        dust.add(new Dust(x + 1, y));
                    }
                }
                if(x > x2) {
                    if (x - 1 != x2){
                        b[x - 1][y] = a[x][y];
                        dust.add(new Dust(x - 1, y));
                    }
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







