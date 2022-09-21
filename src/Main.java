import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<tomato> a = new LinkedList<>();
    static tomato[][]toma;
    static int m, n ,h;

    public static void main(String[] args) throws IOException {
       StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); //col
        n = Integer.parseInt(st.nextToken()); //row
        h = Integer.parseInt(st.nextToken());
        int temp, count = 0;
        boolean zero = false;

       toma = new tomato[n * h][m];

       for (int i = 0 ; i< n * h; i++) {
           st = new StringTokenizer(br.readLine());
           for (int j = 0; j < m ; j++) {
               toma[i][j] = new tomato(Integer.parseInt(st.nextToken()), i, j, false);
               if(toma[i][j].status == 0)
                   zero = true;
           }
       }
       if(zero) {
           for (int i = 0; i < n * h; i++) {
               for (int j = 0; j < m; j++)
                   if (toma[i][j].status == 1 && !toma[i][j].vis)
                       toma[i][j].add();
           }
           while (!a.isEmpty()) {
               count++;
               temp = a.size();
               for (int i = 0; i < temp; i++) {
                   a.peek().status = 1;
                   a.peek().vis = false;
                   a.poll().add();
               }
           }
           for (int i = 0; i < n * h; i++)
               for (int j = 0; j < m; j++)
                   if (!toma[i][j].vis) {
                       count = -1;
                       break;
                   }
       }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();

    }
    static class tomato {
        int status;

        public tomato(int status, int x, int y, boolean vis) {
            this.status = status;
            this.x = x;
            this.y = y;
            this.vis = vis;
        }
        public void add(){

            if(this.vis)
                return;
            else
                this.vis = true;

            if(this.status == 1) {
                if (this.x % n > 0)
                    toma[this.x - 1][y].add();
                if (this.x % n < n - 1)
                    toma[this.x + 1][y].add();
                if (this.y  > 0)
                    toma[this.x][this.y -1].add();
                if (this.y  < m - 1)
                    toma[this.x][this.y + 1].add();
                if((this.x / n) + 1 > 1 )
                    toma[this.x - n][this.y].add();
                if((this.x / n) + 1 < h )
                    toma[this.x + n][this.y].add();
            }
            else if(this.status == 0)
                a.add(this);


        }

        int x;
        int y;
        boolean vis;

    }

}







