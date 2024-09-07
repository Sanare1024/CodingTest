package baekjoon.b1tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk11005 {//0902 //0917 다시

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder(); //진수 바뀐거 저장용

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        //10진수 수 n을 b진수 수로 바꿈
        //n을 b로 계속 나눈 나머지 가 바뀐 진수
        //받은게 10을 넘어가면 char로 A : 10..... ~ Z : 35까지 대응하고 b수를 10으로 표현

        while(n > 0) { // n이 <= 0 되면 스탑

            if (n % b < 10) {
                sb.append(n % b);
            } else { //나머지가 10 이상일때
                sb.append((char)((n % b) + 55)); //'A' 가 65인데 나머지가 10 이상이니까 55부터
            }

            n = n / b;
        }

        String reverse = "";
        for(int i = sb.length() - 1; i >= 0; i--) { //뒤집기
            reverse += sb.charAt(i);
        }

        System.out.println(reverse);
    }
}//0935
