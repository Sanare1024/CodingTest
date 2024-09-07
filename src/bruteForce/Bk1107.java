package bruteForce;

import java.util.Scanner;

public class Bk1107 {
    //+-만  vs 숫자를 누르고 차이 만큼 +-

    static boolean[] number;
    static int n, m, goal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        number = new boolean[10]; //0 부터 9

        if(m > 0){ // m이 0이 아닐떄 고장난 버튼 체크
            for (int i = 0; i < m; i++){
            number[sc.nextInt()] = true; //트루가 고장난거
            }
        }

        goal = Math.abs(n - 100);

        for(int i = 0; i <= 999999; i++){
            String str = String.valueOf(i);
            int len = str.length();
            int min = 0; //최소값 저장할곳

            boolean check = false;
            for(int j = 0; j < len; j++){
                 if(number[str.charAt(j) - '0']) {// true가 고장난거
                     check = true;
                     break;
                 }
            }

            if (!check) { //고장난거 하나도 누르지 않았다면
                min = Math.abs(n - i) + len; // n 에서 i만큼 뺀거  +  번호 누른횟수
                goal = Math.min(goal, min); //
            }
        }

        System.out.println(goal);
    }
}
