package Recursive;

import java.io.*;

public class Star11 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        String zero = "  *  \n * * \n*****";

        star(3, n, zero);

        bw.flush();
        bw.close();
    }
    static void star  (int start, int end, String pstar) throws IOException {
        if(start == end)
            bw.write(pstar);
        else {
            String[] prestar = pstar.split("\n");
            StringBuilder star = new StringBuilder();
            String blank = " ";

            for (int i = 0; i < start; i++)
                star.append(blank.repeat(start)).append(prestar[i]).append(blank.repeat(start)).append("\n");
            for (int i = 0; i < start; i++)
                star.append(prestar[i]).append(" ").append(prestar[i]).append("\n");

            star(2 * start, end, star.toString());
        }
    }
}








