import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] output;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int count = (int) (Math.log(n / 3) / Math.log(2));
        output = new String[n];
        Arrays.fill(output, "");

        for (int i = 0 ; i < n; i ++)
            for (int j = 1; j < n - i; j ++)
                output[i] += " ";

        print(count, 0, n / 2);

        for (int i = 0 ; i < n; i ++)
            for (int j = 1; j < n - i; j ++)
                output[i] += " ";


        for (String a : output)
            bw.write(a + "\n");
        bw.flush();
        bw.close();
    }
    static void print(int count, int row,int n){
        if(count == 0){
            output[row] += "*";
            output[row + 1] += "* *";
            output[row + 2] += "*****";
        }
        else{
            print(count - 1, row,  n);
            print(count - 1, row  + n,  n);
            for (int i = 0 ; i < 2 * n; i ++)
                for (int j = 0; j < n - i; j++)
                    output[row +  n + i] += " ";
            print(count - 1, row + n, n);
        }
    }
}







