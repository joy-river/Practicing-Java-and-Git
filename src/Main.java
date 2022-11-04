import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[][] table = new String[n][];
        for (int i = 0 ; i < n ; i ++)
            table[i] = br.readLine().split(" ");

        for (int i = 0 ; i < n ; i ++)
            for (int j = 0 ; j < n ; j ++)
                for (int s = 0 ; s < n; s++)
                    if(table[j][s].equals("0"))
                     table[j][s] = table[j][i].equals("1") && table[i][s].equals("1") ? "1" : "0";




        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++)
                bw.write(table[i][j] + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }




}


