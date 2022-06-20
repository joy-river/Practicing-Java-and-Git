import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int [][] table = new int[n][n];
        String [] line;

        for (int i = 0 ; i < n ; i ++){
            line = br.readLine().split("");
            for (int j = 0 ; j < n ; j++)
                table[i][j] = Integer.parseInt(line[j]);
        }


        bw.flush();
        bw.close();
    }
    static int counting (int[][]table,int i, int j, int a){
        int temp;
        int temp0 = 0 , temp1 = 0;
        StringBuilder add = new StringBuilder();
        if(a == 1)
            return table[i][j];
        else{
            add.append("(");
            for (int k = 0 ; k < 2; k++)
                for (int l = 0 ; l < 2; l++) {
                    temp  = counting(table, i + k * (a / 2), j + l * (a / 2), a / 2);
                    if (temp == 0) {
                        temp0++;
                        add.append("0");
                    }
                    else if (temp == 1) {
                        temp1++;
                        add.append("1");
                    }
                }
            if(temp0 == 4 && a != n) {
                return 0;
            }
            else if (temp1 == 4 && a != n){
                return 1;
            }
            else if(temp0 == 4) {
                return 0;
            }
            else if (temp1 == 4){
                return 1;
            }
            else
                return -1;
        }
    }


}
