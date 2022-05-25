import java.io.*;

public class backup {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n];
        int count = 0;

        for (int i = 1 ; i < 10 ; i ++){
            d[0] = i;
            for (int j = 0 ; j < n - 1 ; j ++) {
                d[j + 1] = d[j] + 1;
                if(d[j] != 0)
                    d[j + 1] = d[j] - 1;
            }
        }


        bw.write(Integer.toString(d[n]));
        bw.flush();
        bw.close();
    }
    static void stair (int [] d, int dep){
        d[dep + 1] = d[dep] + 1;
        stair(d, dep + 1);
        //d[dep + 1] = 첫자리 + 계단수 + 마지막 자리 둘 중
    }
}
