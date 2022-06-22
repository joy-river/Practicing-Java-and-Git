package divandconq;

import java.io.*;


public class Multiply {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] input =  br.readLine().split(" ");
        Long[] var = new Long [3];
        for (int i = 0 ; i < 3; i ++)
            var[i] = Long.parseLong(input[i]);

        bw.write(Long.toString(mult(var[1] , var[2], var[0] % var[2] , 1L)));
        bw.flush();
        bw.close();
    }
    static Long mult (Long b ,Long c, Long num, Long result){
        Long temp;
        if (b != 1){
            temp = mult(b / 2, c, num, result);
            result = b % 2 == 0 ? (temp * temp % c) : ((temp * temp % c) * num) % c;
            return result;
        }
        else
            return num;
    }
}
