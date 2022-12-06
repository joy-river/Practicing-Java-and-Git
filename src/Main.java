import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String pat = br.readLine();


        while(input.contains(pat))
        input = input.replaceAll(pat, "");


        bw.write(input.equals("") ? "FRULA" : input);
        bw.flush();
        bw.close();
    }

}








