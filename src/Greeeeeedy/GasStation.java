package Greeeeeedy;

import java.io.*;

public class GasStation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] leng = br.readLine().split(" ");
        String[] cost = br.readLine().split(" ");
        long sum = 0, cheap, temp;

        cheap = Integer.parseInt(cost[0]);
        for (int i = 0 ;i < n - 1 ; i ++){
            temp = Integer.parseInt(cost[i]);
            if(temp < cheap)
                cheap = temp;
            sum += cheap * Integer.parseInt(leng[i]);
        }


        bw.write(Long.toString(sum));
        bw.flush();
        bw.close();
    }

}

