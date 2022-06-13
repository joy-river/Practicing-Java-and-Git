package Queue;

import java.io.*;
import java.util.*;

public class SpinningQueue {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int count = 0, temp;
        input = br.readLine().split(" ");
        int [] num = new int [m];
        for (int i = 0 ; i < m; i++)
            num[i] = Integer.parseInt(input[i]);


        for (int i = 0 ; i < m ; i++){

            if(num[i] > n / 2 + 1) {
                temp = n - num[i] + 1;
                for (int j = i + 1 ; j < m ; j ++)
                    num[j] += temp;
            }
            else {
                temp = num[i] - 1;
                for (int j = i + 1 ; j < m ; j ++)
                    num[j] -= temp;
            }
            count += temp;
            for (int j = i + 1; j < m ; j ++){
                if (num[j] > n)
                    num[j] = (num[j] % n == 0 ? n : num[j] % n);
                else if (num[j] < 1)
                    num[j] = (Math.abs(num[j]) % n == 0 ? n : n - Math.abs(num[j]) % n);
                num[j]--;
            }
            n--;

        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

}
