package B2tr;

import java.util.Scanner;

public class Bk8958 {//2257

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] str = new String[t];



        for(int i = 0; i < t; i++) { //t 만큼 문자열받고
            str[i] = sc.next();
        }

        for (int i = 0; i < t; i++) {
            int count = 0; // 연속 몇번 O인지 그래서 X 만나면 count 초기화 하면될듯?
            int total = 0; // 총 점수

            for(int j = 0; j < str[i].length(); j++) {
                if (str[i].charAt(j) == 'O') { // charAt 이랑 아예 char 랑 비교
                    count++; // O 만날때 마다 count 증가 연속되면 2 3 되겠지
                    total += count; // 총점에 누적
                } else { // X 만났을 때
                    count = 0; //count 를 0으로 초기화
                }
            }

            System.out.println(total);
        }
    }
} //2315
