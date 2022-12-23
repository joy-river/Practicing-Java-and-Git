package GraphTheory;

import java.io.*;
import java.util.*;

public class MovingPipe1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[][] table = new String [n][];
        for (int i = 0 ; i < n ; i++)
            table[i] = br.readLine().split(" ");

        bw.write(table[n - 1][n - 1].equals("0") ? Integer.toString(bfs(table, n)) : "0");

        bw.flush();
        bw.close();
    }
    //가로 : 0, 세로 : 1, 대각 : 2
    static int bfs(String[][] table, int n){
        int count = 0, x, y;
        Pipe temp;
        Queue<Pipe> next = new LinkedList<>();
        next.add(new Pipe(0, 1 , 0 ));

        while(!next.isEmpty()){
            temp = next.poll();
            x = temp.x;
            y = temp.y;
            boolean right = false;
            boolean down = false;
            boolean diag = false;

            if(x == n - 1 && y == n - 1)
                count++;
            else if(x == n - 1){
                if(temp.pos != 1)
                    if(table[x][y + 1].equals("0"))
                        next.add(new Pipe(x, y + 1, 0));
            }
            else if(y == n - 1){
                if(temp.pos != 0)
                    if(table[x + 1][y].equals("0"))
                        next.add(new Pipe(x + 1, y , 1));
            }
            else {
                if (table[x + 1][y].equals("0"))
                    down = true;
                if (table[x][y + 1].equals("0"))
                    right = true;
                if (right && down && table[x + 1][y + 1].equals("0"))
                    diag = true;

                switch(temp.pos){
                    case(0) : if(right) next.add(new Pipe(x, y + 1 , 0)); if(diag) next.add(new Pipe(x + 1, y + 1, 2)); break;
                    case(1) : if(down)  next.add(new Pipe(x + 1, y, 1)); if(diag) next.add(new Pipe(x + 1, y + 1, 2)); break;
                    case(2) : if(down) next.add(new Pipe(x + 1, y, 1)); if(right) next.add(new Pipe(x, y + 1, 0)); if(diag) next.add(new Pipe(x + 1, y + 1, 2)); break;
                }
            }

        }


        return count;
    }
}
class Pipe{
    int x, y;

    public Pipe(int x, int y, int pos) {
        this.x = x;
        this.y = y;
        this.pos = pos;
    }

    int pos;
}






