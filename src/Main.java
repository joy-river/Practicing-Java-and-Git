import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("");
        int result = input.length;
        int [] pal = new int[result + 1];
        for (int i = 1 ; i <= pal.length ; i++ )
            pal[i] = i;


        bw.flush();
        bw.close();
    }




}



