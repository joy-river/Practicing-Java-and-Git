import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] input;
    static long output = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n;
        while (true) {
            n = Integer.parseInt(st.nextToken());
            if (n == 0)
                break;
            else {
                input = new long[n];
                for (int i = 0; i < n; i++)
                    input[i] = Long.parseLong(st.nextToken());
            }
            output = 0;
            hist(0, n - 1);
            bw.write(output + "\n");
            st = new StringTokenizer(br.readLine());
        }

        bw.flush();
        bw.close();
    }

    static void hist(int start, int end) {
        long min = input[start];
        int spot = start;

        for (int i = start + 1 ; i <= end ; i++)
           if(input[i] < min){
               min = input[i];
               spot = i;
           }
       output = Math.max(min * (end - start + 1), output);
       if(start != spot) hist (start , spot -1);
       if(end != spot) hist (spot + 1, end);
    }
}

class element {
    int index;
    public element(int index, long val) {
        this.index = index;
        this.val = val;
    }
    long val;
}


