package Stack;

import java.io.*;
import java.util.*;

public class IOIOIO {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = 2 * Integer.parseInt(br.readLine()) + 1;
        int m = Integer.parseInt(br.readLine());
        String [] input = br.readLine().split("");
        Stack<String> a = new Stack<>();
        int i = 0, result = 0;

        while(i !=  m){
            if(a.isEmpty()) {
                if (input[i].equals("I"))
                    a.add("I");
            }
            else{
                if(a.peek().equals(input[i])){
                    if(a.size() >= n)
                        result += 1 + (a.size() - n) / 2;
                    a.clear();
                    i--;
                }
                else
                    a.add(input[i]);
            }
            i++;
        }
        if(a.size() >= n)
            result += 1 + (a.size() - n) / 2;

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();

    }




}







