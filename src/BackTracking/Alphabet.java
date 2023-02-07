package BackTracking;

import java.io.*;
import java.util.*;


public class Alphabet {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[][] input;
    static HashSet<String> memo = new HashSet<>();
    static int r, c, result = 0;

    public static void main(String[] args) throws IOException{
        StringTokenizer st= new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        input = new String[r][c];

        for (int i = 0 ; i < r ; i ++)
            input[i] = br.readLine().split("");

        memo.add(input[0][0]);
        Alpha_Board(0, 0 ,1);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }

    static void Alpha_Board(int x, int y, int count){
        result = Math.max(result, count);

        if(x < r - 1 && !memo.contains(input[x + 1][y])) {
            memo.add(input[x + 1][y]);
            Alpha_Board(x + 1, y, count + 1);
            memo.remove(input[x + 1][y]);
        }
        if(x > 0 && !memo.contains(input[x - 1][y])) {
            memo.add(input[x - 1][y]);
            Alpha_Board(x - 1, y, count + 1);
            memo.remove(input[x - 1][y]);
        }
        if(y < c - 1 && !memo.contains(input[x][y + 1])) {
            memo.add(input[x][y + 1]);
            Alpha_Board(x, y + 1, count + 1);
            memo.remove(input[x][y + 1]);
        }
        if(y > 0  && !memo.contains(input[x][y - 1])) {
            memo.add(input[x][y - 1]);
            Alpha_Board(x, y - 1, count + 1);
            memo.remove(input[x][y - 1]);
        }

    }
}







