import java.io.IOException;
import java.util.Scanner;


    public class goldbug {
        public static void main(String[] args) throws IOException {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            for (int i = 0; i< n; i++){
                prime(scan.nextInt());
            }

        }
        static int prime (int a){
            int[] arr = new int [a + 1];
            for (int i = 2 ; i <arr.length;i++)
                arr[i] = i;
            arr[1]  = -1;
            for (int i = 2; i <= arr.length / 2; i++){
                for (int j = 2; j * i < arr.length;j++){
                    arr[i * j] = -1;
                }
            }
            part (arr, a);
            return 0;
        }
        static int part(int[] a, int b){
            int big = 0, small = 0;
            int j = 0;
            while(small == 0) {
                for (int i = b / 2 + j; i < a.length; i++) {
                    if (a[i] != -1) {
                        big = a[i];
                        break;
                    }
                }
                for (int i = b / 2; i > 1; i--) {
                    if (a[i] == b - big) {
                        small = a[i];
                        break;
                    }
                }
                j++;
            }
            System.out.println(small +" " + big);
            return 0;
        }
    }
