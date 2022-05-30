import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] stuff = new int [2][n];
        int[][] dp = new int [k + 1][n + 1];
        int max = 0;

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++)
                stuff[j][i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < k + 1; i ++){
            for (int j = 1 ; j < n + 1 ; j ++){
                if(i >= stuff[0][j - 1])
                    dp[i][j] = Math.max(dp[i][j - 1] , dp[i - stuff[0][j - 1]][j - 1] + stuff[1][j - 1]);
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }

}
