package divandconq;

import java.io.*;

public class MakingColoredPaper {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int zero = 0, one = 0, n;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        int[][] table = new int[n][n];
        String[] input;

        for (int i = 0 ; i < n ; i ++){
            input = br.readLine().split(" ");
            for (int j = 0 ;j < n; j++)
                table[i][j] = Integer.parseInt(input[j]);
        }
        counting(table, 0 , 0 ,n);
        bw.write(zero +"\n" + one);
        bw.flush();
        bw.close();
    }
    static int counting (int[][]table,int i, int j, int a){
        int temp;
        int temp0 = 0 , temp1 = 0;
        if(a == 1) {
            return table[i][j];
        }
        else{
            for (int k = 0 ; k < 2; k++)
                for (int l = 0 ; l < 2; l++) {
                    temp  = counting(table, i + k * (a / 2), j + l * (a / 2), a / 2);
                    if (temp == 0) {
                        temp0++;
                        zero++;
                    }
                    else if (temp == 1) {
                        temp1++;
                        one++;
                    }
                    else{} // return -1일때;;;;;;;;;;;

                }
            if(temp0 == 4 && a != n) {
                zero -= 4;
                return 0;
            }
            else if (temp1 == 4 && a != n){
                one -= 4;
                return 1;
            }
            else if(temp0 == 4) {
                zero -= 3;
                return 0;
            }
            else if (temp1 == 4){
                one -= 3;
                return 1;
            }
            else
                return -1;
        }
    }

}
