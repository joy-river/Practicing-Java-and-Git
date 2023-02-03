package PrefixSum;

import java.io.*;
import java.util.*;


public class PartSum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int temp = 0, last = 0, Min_Length = Integer.MAX_VALUE;

        Queue<Integer> sum = new LinkedList<>();
        sum.add(0);

        st = new StringTokenizer(br.readLine());


        for(int i = 0 ; i < n ; i++) {
            temp = Integer.parseInt(st.nextToken());
            if(temp >= s){
                Min_Length = 1;
                break;
            }
            sum.add(last = (temp + last));
            if (last >= s) {
                while (!sum.isEmpty()) {
                    temp = sum.poll();
                    if (last - temp >= s)
                        Min_Length = Math.min(Min_Length, sum.size());
                    if (last - temp < s)
                        break;
                }
                if (sum.isEmpty())
                    break;
            }
        }


        bw.write(Min_Length == Integer.MAX_VALUE ? "0" : Integer.toString(Min_Length));
        bw.flush();
        bw.close();
    }


}







