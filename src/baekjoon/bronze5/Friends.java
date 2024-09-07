package baekjoon.bronze5;

import java.util.Scanner;

public class Friends {

    public static void main(String[] args) {
        //인원수 N명, 한사람이 M번 받으면 끝, 받은 횟수가 홀수면 시계로 L, 짝수면 반시계로 L
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int[] people = new int[N]; //어떤 사람이 받은 공횟수 저장
        int index = 0;
        int total = 0; //총 몇번 던지는지

        while(true) {

            if(people[index] % 2 == 1){
                index = (index + L) % N;
            } else {
                index = (index + N - L) % N;
            }
            people[index]++;

            if (people[index] == M) {
                break;
            }
            total++;
        }

        System.out.println(total);
    }
}
