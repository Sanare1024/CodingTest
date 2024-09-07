package baekjoon.b1tr;

import java.util.Scanner;

public class Bk4344___ {//1321

    public static void main(String[] args) {
        // 테스트 케이스의 개수 C
        //학생의 수 N(1 ≤ N ≤ 1000, N은 정수) 이어서 N명의 점수 (0<= 점수 <= 100)
        // 평균을 넘는 학생의 비율을 반올림하여 소수점 셋째자리까지출력
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();


        for (int i = 0; i < c; i++) {
            int n = sc.nextInt();
            int[] stu = new int[n]; //성적 넣어둘곳 나중에 평균이랑 비교

            double sum = 0; // 소수점 나와야하니까 더블....?

            for (int j = 0; j < n; j++) {// 성적입력
                int score = sc.nextInt();
                stu[j] = score;
                sum += score; //성적합 누적
            }

            double ave = sum / n;//평균
            double count = 0;//평균 넘는 친구

            for (int j = 0; j <n; j++) {
                if (stu[j] > ave) {
                    count++;
                }
            }

            System.out.printf("%.3f%%\n",(count/n)*100); //System.out.printf("%. 3f")  = 소수점 3째자리 까지 표기, 부동소수점 뒤에 %%\n은 %를 표시하기 위한
            //Math.round 써봤는데 40.000이 표현 안됨
        }
    }
} //1338 임시보류 https://coding-factory.tistory.com/250
