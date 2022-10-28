import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count;
    public static void main(String[] args) throws IOException {

        int chan = Integer.parseInt(br.readLine());
        int beeg = chan != 0 ? (int) Math.log10(chan) : 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        if(n != 0) st = new StringTokenizer(br.readLine());
        boolean[] able = new boolean[10];

        count = Math.abs(chan - 100);

        for (int i = 0 ; i < n ; i ++)
            able[Integer.parseInt(st.nextToken())] = true;

        if(count <= beeg || n == 10)
            bw.write(Integer.toString(count));
        else{
            int big = bigger(able, chan, beeg);
            int smol = smaller(able,chan,beeg);

            smol = Math.min(Math.abs(big - chan) + (big != 0 ? (int)Math.log10(big) + 1 : 1) , Math.abs(smol - chan) + (smol != 0 ? (int)Math.log10(smol) + 1 : 1));

            if(!able[chan / (int) Math.pow(10, beeg)]){
                int sam = same(able, chan, beeg);
                smol = Math.min(smol , Math.abs(sam - chan) + (sam != 0 ? (int)Math.log10(sam) + 1 : 1));

                bw.write(Integer.toString(Math.min(smol, count)));
            }
            else{
                bw.write(Integer.toString(Math.min(smol, count)));
            }
        }
        bw.flush();
        bw.close();
    }

    static int bigger(boolean[] able, int num, int digit){
        int temp = 9999999;
        int first = num / (int) Math.pow(10,digit);
       for (int i = first; i < 10; i ++){
           if(!able[i]){
               temp = i * (int)Math.pow(10,digit--);
               for (int j = 0 ; j < 10 ; j++){
                   if(!able[j]) {
                       for (int s = 0; s <= digit; s++)
                           temp += j * (int) Math.pow(10, s);
                       break;
                   }
               }
               return temp;
           }
       }
       for (int i = 1; i < first; i ++){
           if(!able[i]){
               temp = i * (int)Math.pow(10, digit + 1);
               for (int j = 0 ; j < 10 ; j++){
                   if(!able[j]) {
                       for (int s = 0; s <= digit; s++)
                           temp += j * (int) Math.pow(10, s);
                       break;
                   }
               }
               return temp;
           }

       }
        return temp;
    }
    static int same(boolean[]able, int num,int digit) {
        if(digit < 0)
            return 0;

        int a = (int) (num / Math.pow(10, digit));
        int result = 100;
        for (int i = 1; i < 10; i  ++)
            if(!able[i])
                if(Math.abs(result - a) > Math.abs(i - a))
                    result = i;

        return (int) (result * Math.pow(10, digit) + same(able, (int) (num % Math.pow(10, digit)), digit - 1));
    }

    static int smaller(boolean[] able, int num, int digit) {
        int temp = 9999999;
        if (num != 0) {
            int first = num / (int) Math.pow(10, digit) - 1;
            for (int i = first; i >= 0; i--) {
                if (!able[i]) {
                    temp = i * (int) Math.pow(10, digit--);
                    for (int j = 9; j >= 0; j--) {
                        if (!able[j]) {
                            for (int s = 0; s <= digit; s++)
                                temp += j * (int) Math.pow(10, s);
                            break;
                        }
                    }
                    return temp;
                }
            }
            if(digit > 0) {
                for (int i = 9; i > first; i--) {
                    if (!able[i]) {
                        temp = i * (int) Math.pow(10, --digit);
                        for (int j = 9; j >= 0; j--) {
                            if (!able[j]) {
                                for (int s = 0; s <= digit - 1; s++)
                                    temp += j * (int) Math.pow(10, s);
                                break;
                            }
                        }
                        return temp;
                    }
                }
            }
        }
        return temp;
    }

}



