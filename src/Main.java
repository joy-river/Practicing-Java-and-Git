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

        bw.flush();
        bw.close();
    }
    static int MiMun(String[][] table){
        Dust puri = null;
        Queue<Dust> dust = new LinkedList<>();
        for (int i = 0 ; i < r ; i ++)
            for (int j = 0 ; j < c; j ++) {
                if (table[i][j].equals("-1")) {
                    if (puri == null) puri = new Dust(i, j, -1);
                }
                else if (!table[i][j].equals("0"))
                    dust.add(new Dust(i, j, Integer.parseInt(table[i][j])));
            }

    }
    static void diff(){

    }
    static void flow(){

    }
}
class Dust {
    int x;

    public Dust(int x, int y, int amount) {
        this.x = x;
        this.y = y;
        this.amount = amount;
    }

    int y;
    int amount;
}







