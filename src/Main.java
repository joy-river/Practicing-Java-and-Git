import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
       String[] cal = br.readLine().split("[+\\-]");
       int sum = 0;



        bw.write(Long.toString(sum));
        bw.flush();
        bw.close();
    }

}

