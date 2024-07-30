package B1tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk1924 { //1540

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int x = Integer.parseInt(st.nextToken());  //월
        int y = Integer.parseInt(st.nextToken());  //일

        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"}; //1월 1일이 월요일이랬으니 7일이 SUN % 7 = 0

        int sum = y; //일수 의 총합 넣을 곳, 미리 지정일수 넣음
        for(int i = 0; i < x - 1; i++) {// 지정월 전달까지 day 다 더하기
            sum += month[i];
        }

        System.out.println(day[sum % 7]); //총 일수 7로 나눈 나머지가 요일

    }
} //1555
