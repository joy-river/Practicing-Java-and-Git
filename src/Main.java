import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ;i < n; i ++)
            stack.push(Integer.parseInt(num[i]));

        for (int i = 0 ; i < n ; i ++)


        bw.flush();
        bw.close();
    }

}


