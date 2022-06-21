package divandconq;


import java.io.*;

public class NumberOfPaper {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int zero = 0, one = 0, minus = 0, n;
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
        bw.write(minus + "\n" + zero +"\n" + one);
        bw.flush();
        bw.close();
    }
    static int counting (int[][]table,int i, int j, int a){
        int temp;
        int tempm = 0 , temp0 = 0 , temp1 = 0;
        if(a == 1) {
            return table[i][j];
        }
        else{
            for (int k = 0 ; k < 3; k++)
                for (int l = 0 ; l < 3; l++) {
                    temp  = counting(table, i + k * (a / 3), j + l * (a / 3), a / 3);
                    if (temp == 0) {
                        temp0++;
                        zero++;
                    }
                    else if (temp == 1) {
                        temp1++;
                        one++;
                    }
                    else if (temp == -1){
                        tempm++;
                        minus++;
                    }
                }
            if(temp0 == 9) {
                zero -= a != n? 9 : 8;
                return 0;
            }
            else if (temp1 == 9){
                one -= a != n ? 9 : 8;
                return 1;
            }
            else if (tempm == 9){
                minus -= a != n? 9 : 8;
                return -1;
            }

            else
                return -10;
        }
    }

}
