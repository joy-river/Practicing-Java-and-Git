package NumberTheory;

import java.io.*;
import java.util.*;

public class KaIngCalendar {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] input = new int[4];
        int count,first, temp;
        for (int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++)
                input[j] = Integer.parseInt(st.nextToken());

            first = input[2] % input[1] == 0 ? input[1] : input[2] % input[1];

            if((input[3] - input[2]) % gcd(input[0] , input[1]) != 0)
                bw.write(-1 + "\n");

            else if(first == input[3])
                bw.write(input[2] + "\n");

            else{
                count = 1;
                while(true){
                    temp =  (count * input[0] + input[2]) % input[1];
                    if(temp == 0)
                        temp = input[1];
                    if(temp == first) {
                        bw.write(-1 + "\n");
                        break;
                    }
                    else if (temp == input[3]){
                        bw.write(count * input[0] + input[2] + "\n");
                        break;
                    }
                    else
                        count++;
                }
            }

        }

        bw.flush();
        bw.close();

    }

    static int gcd(int a, int b){
        if(b == 0)
            return a;

        return gcd(b, a % b);
    }

}







