package baekjoon.bronze5;

import java.util.Arrays;
import java.util.Scanner;

public class Jumong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // N 받
        int m = sc.nextInt(); // M 받
        int count = 0; // 재료가 들어간 횟수 카운팅 변수

        int[] array = new int[n]; // N개수 받은거 넣을 수열
        int start = 0; // 스타트 인덱스
        int end = array.length - 1; // 엔드 인덱스
        int sum = 0; //인덱스 2개 합친값 넣을곳
        //for문으로 N개수만큼 수열 받아서 넣기
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        //배열 받은거 오름차순으로 정리해야 하는데 for문 돌려야하나....?
        /*int a = 0; //임시저장용
        for (int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[i] > array[j]) {
                    a = array[i];
                    array[i] = array[j];
                    array[j] = a;
                }
            }
        }*/
        Arrays.sort(array); // 위에가 혼자 짠건데 이렇게 좋은 기능이 있었네 ㅂㄷ
        while (start < end) { //투 포인터
            sum = array[start] + array[end];
            if (sum < m) {
                start++;
            } else if (sum == m) {
                start++;
                end--;
                count++;
            } else {
                end--;
            }
        }
        System.out.println(count);
    }
}
