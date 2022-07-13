import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> wire = new ArrayList<>();
    static int n;
    public static void main(String[] args) throws IOException {
       StringTokenizer st = new StringTokenizer(br.readLine());
       int k = Integer.parseInt(st.nextToken());
       n = Integer.parseInt(st.nextToken());
       for (int i = 0 ; i < n ; i ++)
           wire.add(Integer.parseInt(br.readLine()));
       Collections.sort(wire);
        cut(0 ,k - 1);
        bw.flush();
        bw.close();
    }

    static int cut(int start, int end){
        int mid = (start + end) / 2;
        int count = 0;
        if(start == end){
             return -1;
        }
        else{
            for (int i = mid; i <= end ; i++)
                count += wire.get(i) / wire.get(mid);
            if(count > n)
                cut(mid, end);
            else if (count < n)
                cut(start , mid);
            else
                return wire.get(mid);

            return wire.get(mid);
        }
    }

}


