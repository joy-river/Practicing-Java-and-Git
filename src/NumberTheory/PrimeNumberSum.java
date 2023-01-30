package NumberTheory;

import java.io.*;
import java.util.*;


public class PrimeNumberSum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, count = 0;
    static Queue<Long> prime = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int limit = (int) Math.sqrt(n);
        boolean [] Era = new boolean[n + 1];
        long temp = 0, last = 0, poll;

        prime.add(0L);


        for (int i = 2; i <= limit; i++){
            if(!Era[i]){
                for (int j = 2; i * j <= n ; j ++)
                    Era[i * j] = true;
            }
        }

        for(int i = 2 ; i < n ; i++)
            if(!Era[i]) {
                last = i + temp;
                prime.add(last);
                if(last >= n) {
                    while (!prime.isEmpty()) {
                        poll = prime.poll();
                        if (last - poll == n)
                            count++;
                        else if (last - poll < n)
                            break;
                    }
                    if (prime.isEmpty())
                        break;
                }
                temp = last;
            }
        if(n != 1 && !Era[n])
            count++;




        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }


}





