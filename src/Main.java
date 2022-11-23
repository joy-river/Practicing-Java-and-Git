import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        String[][] sticker = new String[2][];


        for (int i = 0 ; i < t; i ++){
            int n = Integer.parseInt(br.readLine());
            int [] dp = new int[n + 1];
            sticker[0] = br.readLine().split(" ");
            sticker[1] = br.readLine().split(" ");

            dp[0] = 0;


        }

        bw.flush();
        bw.close();
    }

}






