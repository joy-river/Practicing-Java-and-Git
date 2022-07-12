package BinarySearch;

import java.io.*;
import java.util.*;

public class FindNumber {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> input = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i ++)
            input.add(Integer.parseInt(st.nextToken()));
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Collections.sort(input);
        for (int i = 0; i < m ; i++)
            bw.write(bs(Integer.parseInt(st.nextToken()), 0, n- 1) + "\n");

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


