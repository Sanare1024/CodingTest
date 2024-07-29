package B3tr;

import java.util.Scanner;

public class Bk5597 {//1107

    public static void main(String[] args) {
        //30 명중 28명 제출 제출 안한 2명을 출력, 작은번호 윗줄 큰번호 아랫줄

        Scanner sc = new Scanner(System.in);
        int[] student = new int[30];// 냈는지 확인할 배열

        for(int i = 0; i < 28; i++) { //28명 제출했으니까 28번 반복
            int a = sc.nextInt(); //출석번호받기
            student[a - 1] = 1; //배열이니까 1칸씩 줄여서 넣기
        }

        for(int i = 0; i < 30; i++) { //30명 체크해서 1안들어간곳 색출
            if(student[i] != 1) {
                System.out.println(i + 1); //밑에서 부터 돌아가니까 작은번호가 먼저
            }

        }
    }
} //1117
