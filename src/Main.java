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
        while(true){
            n = Integer.parseInt(st.nextToken());
            if(n == 0)
                break;
            else{
                input = new long[n];
                for(int i  = 0 ; i < n ; i ++)
                    input[i] = Long.parseLong(st.nextToken());
            }
        }


        bw.flush();
        bw.close();
    }
    static long hist(int start, int end, int n){
        long temp = 0;
        for (int i  = start; i < end; i++){
            if(input[i] > input[i + 1]){
                if(input[i + 1] * (i - start) < temp)ddaa
            }
            else
                temp += input[start];

        }
    }

}


