package B1tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk11050 { //1518

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //여기부터 버퍼드만 써서 익숙해지려함
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //이항연산자  = nCk = n! / (n - k)! * k!
        System.out.println(factorial(n) / (factorial(n - k) * factorial(k)));
    }

    static int factorial (int n){
        //factorial(0) = 1 임
        if (n <= 1) {
            return 1;
        }
        return  n * factorial(n - 1);
    }
} //1539
