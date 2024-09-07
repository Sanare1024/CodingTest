package baekjoon.b1tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk9506 {//0950

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트케이스 마다 한줄에 하나씩 출력해야 한다.
        //n이 완전수라면, n을 n이 아닌 약수들의 합으로 나타내어 출력한다(6 = 1 + 2 + 3).
        //이때, 약수들은 오름차순으로 나열해야 한다.
        //n이 완전수가 아니라면 n is NOT perfect. 를 출력한다.

        while(true) {//한줄마다 하나씩 출력 + -1 입력되야 종료
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());

            if(n == -1) {
                break;
            }

            //약수니까 1은 무조건 포함 && 2부터 나눠가면서 n까지 해서 나머지 0인거 다 추가
            sb.append(n + " = 1");
            int perfect = 1; // 완전수인지 체크용, 약수들 다 더해 넣기

            for (int i = 2; i < n; i++){
                if(n % i == 0){
                    sb.append(" + " + i);
                    perfect += i;
                }
            }

            if (n == perfect){ //이러면 자기자신 약수 제외 총합 = n 이니까 완전수
                System.out.println(sb);
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}//1005
