import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, count = 0;
    static ArrayList<Long> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int limit = (int) Math.sqrt(n);
        boolean [] Era = new boolean[n + 1];
        long temp = 0, last = 0;
        prime.add(0L);


        for (int i = 2; i <= limit; i++){
            if(!Era[i]){
                for (int j = 2; i * j <= n ; j ++)
                    Era[i * j] = true;
            }
        }

        for(int i = 2 ; i <= n / 2 ; i++)
            if(!Era[i]) {
                if(last + i > n)
                    break;
                if(i + temp >= n)
                    prime.add(i + temp);
                temp += i;
                last = i;
            }
        if(!Era[n])
            count++;
        Make_Sum(prime.size() - 1, prime.size() - 2);




        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
    static void Make_Sum(int H_index, int T_index){
        if (T_index < 0)
            return;
        if (prime.get(H_index) < n)
            return;
        else {
            long sum = prime.get(H_index) - prime.get(T_index);
            if (sum == n)
                count++;
            if (sum <= n)
                Make_Sum(H_index, T_index - 1);
            else if (sum > n)
                Make_Sum(H_index - 1, T_index);
        }

    }

}




