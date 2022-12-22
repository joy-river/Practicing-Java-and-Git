import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[][] table = new String [n][];
        for (int i = 0 ; i < n ; i++)
            table[i] = br.readLine().split(" ");

        bw.write(Integer.toString(bfs(table, n)));

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
            if(x == n - 1 && y == n - 1)
                count++;
            else{
                if(x < n - 1 && y < n - 1){
                    if(table[x + 1][y].equals)
                }
                if (temp.x < n - 1){

                }
                if(temp.y < n - 1){

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






