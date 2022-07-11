package divandconq;

import java.io.*;

public class Fibo6 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long mod = 1000000007;
    static matrix2 save;

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());
        long[][] mat = {{1 , 1}, {1 , 0}};
        save = new matrix2(mat);

        bw.write(Long.toString(Matexp(n,save).mat[0][1]));
        bw.flush();
        bw.close();
    }
    static matrix2 Matexp (long n, matrix2 mat){
        matrix2 temp;
        if (n != 1){
            temp = Matexp(n /2 , mat);
            mat = n % 2L == 0 ? mult(temp, temp) :  mult(mult(temp, temp), save);
            return mat;
        }
        else
            return save;

    }
    static matrix2 mult (matrix2 a, matrix2 b){
        long temp;
        matrix2 c = new matrix2(new long [2][2]);
        for (int i = 0 ; i < 2; i ++){
            for (int s = 0 ; s < 2; s++) {
                temp = 0;
                for (int j = 0; j < 2; j++)
                    temp += (a.mat[i][j]  * b.mat[j][s]) % mod;
                c.mat[i][s] = temp % mod;
            }
        }
        return c;
    }
}
class matrix2 {
    public matrix2(long[][] mat) {
        this.mat = mat;
    }
    long[][] mat;
}


