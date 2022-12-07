package Stack;

import java.io.*;
import java.util.*;

public class StringExplosion {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("");
        String[] pat = br.readLine().split("");
        String[] temp = new String[pat.length];
        Arrays.fill(temp, "");
        String end = pat[pat.length - 1];
        Stack<String> a = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (String s : input) {
            a.add(s);

            if(a.peek().equals(end)){
                if(a.size() >= pat.length){
                    for (int i = pat.length - 1; i >= 0 ; i--)
                        if (pat[i].equals(a.peek()))
                            temp[i] = a.pop();
                        else
                            break;
                    if(temp[0].equals(""))
                        Collections.addAll(a, temp);

                    temp = new String[pat.length];
                    Arrays.fill(temp, "");
                }
            }
        }

        while(!a.isEmpty())
            result.append(a.pop());

        bw.write(result.length() == 0 ? "FRULA" : result.reverse().toString());
        bw.flush();
        bw.close();
    }

}









