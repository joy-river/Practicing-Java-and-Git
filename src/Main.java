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
            output = 0;
            hist (0, n);
            bw.write(output + "\n");
            st = new StringTokenizer(br.readLine());
        }

        bw.flush();
        bw.close();
    }
    static long hist(int start, int end){
        long temp = input[start];
        long min = input[start];
        if (start == end)
            return temp;
        else {
            for (int i = start + 1; i < end; i++) {
                if(input[i] >= min){
                    if(temp + min < input[i]) {
                        output = Math.max(temp, output);
                        hist(i, end);
                        return temp;
                    }
                    else
                        temp += min;
                }
                else{
                    min = input[i];
                    if((i + 1 - start) * min  > temp){
                        temp = (i + 1 -start) * min;
                    }
                    else{
                        output = Math.max(temp, output);
                        hist(i ,end);
                        return temp;
                    }
                }
                output = Math.max(temp, output);
            }
        }
    }

}


