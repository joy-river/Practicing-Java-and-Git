import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String [][] table = new String[n][m];
        Queue<node> a = new LinkedList<>();
        int time = 0, temp;
        for (int i = 0; i < n; i++)
            table[i] = br.readLine().split("");
        a.add(new node(0, 0));
        while(!a.isEmpty()){
            time++;
            temp = a.size();
            for (int i = 0 ; i < temp; i++){

            }

        }


        bw.flush();
        bw.close();
    }

}
class node{
    public node(int row, int col) {
        this.row = row;
        this.col = col;
    }
    int row;
    int col;

}





