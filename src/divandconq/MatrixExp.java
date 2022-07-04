package divandconq;

import java.io.*;
import java.util.StringTokenizer;


public class MatrixExp {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int mod = 1000;
    static matrix save;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        int[][] mat = new int[size][size];
        for (int i = 0 ; i < size; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < size; j++)
                mat[i][j] = Integer.parseInt(st.nextToken()) % mod;
        }
        save = new matrix(mat);

        matrix output = Matexp(size, n, save);
        for (int i = 0  ;  i< size; i++) {
            for (int j = 0; j < size; j++)
                bw.write(output.mat[i][j] + " ");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
    static matrix Matexp (int size , long n, matrix mat){
        matrix temp;
        if (n != 1){
            temp = Matexp(size , n /2 , mat);
            mat = n % 2L == 0 ? mult(temp, temp, size) :  mult(mult(temp, temp, size), save, size);
            return mat;
        }
        else{
            return save;
        }
    }
    static matrix mult (matrix a, matrix b , int size){
        int temp;
        matrix c = new matrix(new int [size][size]);
        for (int i = 0 ; i < size; i ++){
            for (int s = 0 ; s < size; s++) {
                temp = 0;
                for (int j = 0; j < size; j++)
                    temp += (a.mat[i][j]  * b.mat[j][s]) % mod;
                c.mat[i][s] = temp % mod;
            }
        }
        return c;
    }
}
class matrix {
    public matrix(int[][] mat) {
        this.mat = mat;
    }
    int[][] mat;
}

