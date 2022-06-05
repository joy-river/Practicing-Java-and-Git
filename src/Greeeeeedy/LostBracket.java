package Greeeeeedy;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LostBracket {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String cal = br.readLine();
        String[] num = cal.split("[+\\-]");
        Pattern p = Pattern.compile("[+\\-]");
        Matcher m = p.matcher(cal);
        int sum = 0, i = 1;
        boolean minus = false;

        sum += Integer.parseInt(num[0]);

        while(m.find()) {
            if (m.group().equals("-")) {
                sum -= Integer.parseInt(num[i]);
                minus = true;
            }
            else
            if (minus)
                sum -= Integer.parseInt(num[i]);
            else
                sum += Integer.parseInt(num[i]);

            i++;
        }




        bw.write(Long.toString(sum));
        bw.flush();
        bw.close();
    }



}

