import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] point = new int[n];
        int[] sum = new int [n];

        for (int i = n - 1 ; i >= 0 ; i--)
            point[i] = Integer.parseInt(br.readLine());

        if(n == 1)
            bw.write(Integer.toString(point[0]));
        else {
            sum[1] = (sum[0] = point[0]) + point[1];
            for (int i = 2; i < n; i++)
                sum[i] = Math.max(sum[i - 2] + point[i], i > 2 ? point[i - 1] + sum[i - 3] + point[i] : 0);
            bw.write(Integer.toString(Math.max(sum[n - 2], sum[n - 1])));
        }
        bw.flush();
        bw.close();
    }
}
