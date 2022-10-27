import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count;
    public static void main(String[] args) throws IOException {

        int chan = Integer.parseInt(br.readLine());
        int beeg = (int) Math.log10(chan);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] able = new boolean[10];

        count = chan > 100 ? chan - 100 : 100 - chan;
        for (int i = 0 ; i < n ; i ++)
            able[Integer.parseInt(st.nextToken())] = true;
        if(count <= beeg)
            bw.write(Integer.toString(count));
        else{
            if(able[chan / (int) Math.pow(10, beeg)]){
                bw.write(same(able, chan, beeg));
            }
            else{

            }
        }
        bw.flush();
        bw.close();
    }

    static int bigger(boolean[] able, int num, int digit){
        int temp;
       for (int i = num / (int) Math.pow(10,digit); i < 10; i ++){
           if(able[i]){
               temp = i * (int)Math.pow(10,digit--);
               for (int j = 0 ; j < 10 ; j++){
                   if(able[j]) {
                       for (int s = 0; s <= digit; s++)
                           temp += j * (int) Math.pow(10, s);
                       break;
                   }
               }
               return temp;
           }
       }
        return Integer.MAX_VALUE;
    }
    static int same(boolean[]able, int num,int digit){

    }

    static int smaller(boolean[] able, int num, int digit) {
        int temp;
        for (int i = 1; i < num / (int) Math.pow(10,digit); i ++){
            if(able[i]){
                temp = i * (int)Math.pow(10,digit--);
                for (int j = 9 ; j >= 0 ; j--){
                    if(able[j]) {
                        for (int s = 0; s <= digit; s++)
                            temp += j * (int) Math.pow(10, s);
                        break;
                    }
                }
                return temp;
            }
        }
        return Integer.MAX_VALUE;
    }

}



