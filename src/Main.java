import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] input;
    static int[][] pal;

    public static void main(String[] args) throws IOException {
        input = br.readLine().split("");
        int n = input.length;
        int result = n;

        pal = new int[n + 1][n + 1];
        for (int i = 0 ; i <= n ; i ++) {
            for (int j = 0; j <= n; j++)
                    pal[i][j] = Integer.MAX_VALUE;
        }

        int [] dp = new int[n + 1];
        for (int i = 0 ; i < pal.length ; i++ )
            dp[1] =


        bw.flush();
        bw.close();
    }



    static int Is_Pal(int start, int end){
        if(end < start)
            return Integer.MAX_VALUE;

        if(end - start <= 1)
            if (input[start].equals(input[end]))
                return pal[start][end] = 1;

        if(pal[start][end] < Integer.MAX_VALUE)
            return pal[start][end];


        else{
            if(input[start].equals(input[end]))
                if(Is_Pal(start + 1, end - 1) == 1)
                    return pal[start][end] = 1;
                else {
                    for (int i = start + 1; i < end; i++)
                        pal[start][end] = Math.min(pal[start][end], Is_Pal(start, i) + Is_Pal(i, end));
                }
        }
    }

}



