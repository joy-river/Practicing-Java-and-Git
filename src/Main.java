import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] input;
    static long[] hist;
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
                hist = new long[n];
                for(int i  = 0 ; i < n ; i ++) {
                    input[i] = Long.parseLong(st.nextToken());
                    hist[i] = -1L;
                }
            }
            output = 0;
            hist (0, n - 1);
            bw.write(output + "\n");
            st = new StringTokenizer(br.readLine());
        }

        bw.flush();
        bw.close();
    }
    static void hist(int start, int end){
        long temp = input[start];
        long min = input[start];
        if (start == end) {
            hist[start] = temp;
            output = Math.max(temp, output);
        }
        else {
            for (int i = start + 1; i <= end; i++) {
                if(input[i] >= min){
                    if(hist[i] == -1)
                        hist(i , end);
                    temp += min;
                }
                else{
                    min = input[i];
                    temp = (i + 1 - start) * min;
                    if(hist[i] == -1)
                        hist(i ,end);
                    }
                output = Math.max(temp, output);
                hist[start] = Math.max(temp, hist[start]);
                }
            }


        }
    }



