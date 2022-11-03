import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[][] table = new String[n][];
        int[][] result = new int[n][n];

        for (int i = 0 ; i < n ; i ++)
            table[i] = br.readLine().split(" ");

        for (int i = 0 ; i < n ; i ++){
            for (int j = 0 ; j < n ; j ++)
                for (int s = 0 ; s < n; s++)
                    result[j][i] = if(table[i][s])
        }





        bw.flush();
        bw.close();
    }




}


