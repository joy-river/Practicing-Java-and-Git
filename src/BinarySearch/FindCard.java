package BinarySearch;

import java.io.*;
import java.util.*;

public class FindCard {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> input = new ArrayList<>();
    static int[] counting = new int[20000002];
    static final int plus = 10000000;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int temp;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i ++) {
            temp = Integer.parseInt(st.nextToken());
            if(counting[temp + plus] == 0) {
                input.add(temp);
                counting[temp + plus]++;
            }
            else
                counting[temp + plus]++;
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Collections.sort(input);
        for (int i = 0; i < m ; i++) {
            temp = Integer.parseInt(st.nextToken());
            bw.write(bs(temp, 0, input.size() - 1) * counting[temp + plus] + " ");
        }
        bw.flush();
        bw.close();
    }
    static int bs (int a, int start, int end){
        if(start == end)
            return input.get(start) == a ? 1 : 0;
        else if(a < input.get(start) || a > input.get(end))
            return 0;
        else
            return input.get((start + end) / 2) == a ? 1 : input.get((start + end) / 2) < a ? bs(a, (start + end) / 2 + 1, end) : bs(a, start, (start + end) / 2 - 1) ;
    }
}



