import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        input = br.readLine().split(" ");
        String[][] b = new String[Integer.parseInt(input[0])][];
        for (int i = 0 ; i < Integer.parseInt(input[0]); i++)
            b[i] = br.readLine().split(" ");

    }
}
