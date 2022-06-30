import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        int [] input = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        String [][] a = new String[input[0]][];
        for (int i = 0 ; i < input[0]; i ++)
            a[i] = br.readLine().split(" ");
        st = new StringTokenizer(br.readLine());
        int [] input2 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        String [][] b = new String[input[0]][];
        for (int i = 0 ; i < input2[0]; i++)
            b[i] = br.readLine().split(" ");

        for (int i = 0 ; i < input[0]; i ++){
            for (int s = 0 ; s < input2[1]; s++) {
                temp = 0;
                for (int j = 0; j < input[1]; j++)
                    temp += Integer.parseInt(a[i][j])  * Integer.parseInt(b[j][s]);
                sb.append(temp + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
