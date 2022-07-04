package divandconq;

import java.io.*;

public class Fibo6 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long mod = 1000000007;
    static matrix save;

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());
        long[][] mat = {{1 , 1}, {1 , 0}};
        save = new matrix(mat);

        bw.write(Long.toString(Matexp(n,save).mat[0][1]));
        bw.flush();
        bw.close();
    }
    static matrix Matexp (long n, matrix mat){
        matrix temp;
        if (n != 1){
            temp = Matexp(n /2 , mat);
            mat = n % 2L == 0 ? mult(temp, temp) :  mult(mult(temp, temp), save);
            return mat;
        }
        else
            return save;

    }
    static matrix mult (matrix a, matrix b){
        long temp;
        matrix c = new matrix(new long [2][2]);
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
class matrix {
    public matrix(long[][] mat) {
        this.mat = mat;
    }
    long[][] mat;
}


