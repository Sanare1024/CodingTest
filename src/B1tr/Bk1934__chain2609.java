package B1tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk1934__chain2609 { //1555 //1605분 까지 고민 앞에 못푼 문제와 상동함
    // 유클리드 호제법까지만 검색해봄
    // 유클리드 호제법 수 a,b가 있을때  a % b 값 r이 0이 아니라면 b % r 을 무한이 반복했을때 r = 0 에 도달한점에서의 b가 최대공약수,
    // 또한 여기서 각 수 a, b를 곱한 값에 최대 공약수를 나눠주면 그것이 최소공배수. 1617까지 공부
    // 따라서 둘다 뜯어고치되 하나는 재귀 하나는 반복으로 해볼예정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int temp = gcd(a, b); //이값이 최대공약수, 따라서 a * b / temp는 최소공배수

            sb.append(a * b / temp).append("\n"); //다음회차 줄띄기
        }

        System.out.println(sb); //한번에 출력
    }

    public static int gcd (int a, int b) {
        while (b != 0) { //b == 0에 도달하면 멈추기
            int r = a % b;

            //gcb (a,b) -> gcb(b,r) r이 0이 될때까지 반복이니까
            a = b;
            b = r;
        } //while 다하고 멈췄을때 == b=0 이니 a값이 최대공약수
        return a; //a값을 리턴
    }
} //1630
