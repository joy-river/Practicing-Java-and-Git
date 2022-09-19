import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
       StringTokenizer st = new StringTokenizer(br.readLine());
       int m = Integer.parseInt(st.nextToken());
       int n = Integer.parseInt(st.nextToken());
       int h = Integer.parseInt(st.nextToken());

       tomato[][] toma = new tomato[m][n * h];

       Queue<tomato> a = new LinkedList<>();

       for (int i = 0 ; i< n * h; i++) {
           st = new StringTokenizer(br.readLine());
           for (int j = 0; j < m ; j++)
               toma[j][i] = new tomato(Integer.parseInt(st.nextToken()), j,i,false);
       }

       for (int i = 0 ; i < m; i ++){
           for (int j = 0 ; j < n * h; j++){
               if(toma[i][j].status == 1 && !toma[i][j].vis){
                   add(toma[i][j]);
               }
           }
       }


   

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

        int x;
        int y;
        boolean vis;

    }

}







