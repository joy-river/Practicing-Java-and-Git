import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n ; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Queue<dslr> bs = new LinkedList<>();
            bs.add(new dslr("", a));
            while (!bs.isEmpty()) {
                int num = bs.peek().num;
                if (num == b) {
                    bw.write(bs.peek().sb.toString() + "\n");
                    break;
                }
                if (num != 0) {
                    bs.add(new dslr(bs.peek().sb +"D", d(num)));
                    bs.add(new dslr(bs.peek().sb +"L", l(Integer.toString(num))));
                    bs.add(new dslr(bs.peek().sb +"R", r(Integer.toString(num))));
                }
                bs.add(new dslr(bs.peek().sb +"S", s(num)));

                bs.poll();

            }
        }

        bw.flush();
        bw.close();
    }


    static int d(int num){
        return (2 * num) % 10000;
    }
    static int s(int num){
        return num == 0 ? 9999 : num - 1;
    }
    static int l(String num){
        String[] split = num.split("");
        StringBuilder sb = new StringBuilder();

        if(split.length == 4){
            for (int i = 1;i < split.length; i++)
                sb.append(split[i]);
            sb.append(split[0]);
        }
        else {
            for (int i = 0; i < split.length; i++)
                sb.append(split[i]);
            sb.append("0");
        }

        return Integer.parseInt(sb.toString());
    }
    static int r(String num){
        String[] split = num.split("");
        StringBuilder sb = new StringBuilder();
        int n = 4 - split.length;

        if(split.length == 4) {
            sb.append(split[split.length - 1]);
            for (int i = 0; i < split.length - 1; i++)
                sb.append(split[i]);
        }
        else{
            sb.append(split[split.length - 1]);
            for (int i = 0 ; i < n ; i++)
                sb.append("0");
            for (int i = 0 ; i < split.length - 1; i ++)
                sb.append(split[i]);
        }

        return Integer.parseInt(sb.toString());
    }
}
class dslr{
    public dslr(String sb, int num) {
        this.sb = sb;
        this.num = num;
    }

    String sb;
    int num;
}


